package com.ufo.service.impl;

import com.google.common.base.CaseFormat;
import com.ufo.dao.GridColumnInfoEntityDao;
import com.ufo.dao.GridExtendInfoEntityDao;
import com.ufo.dao.GridInfoEntityDao;
import com.ufo.entity.DxGridTemplate;
import com.ufo.entity.GridColumnInfoEntity;
import com.ufo.entity.GridExtendInfoEntity;
import com.ufo.entity.GridInfoEntity;
import com.ufo.service.GridService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/3.
 */
@Service("gridService")
public class GridServiceImpl implements GridService {

    @Autowired
    private GridColumnInfoEntityDao gridColumnInfoEntityDao;

    @Autowired
    private GridInfoEntityDao gridInfoEntityDao;

    @Autowired
    private GridExtendInfoEntityDao gridExtendInfoEntityDao;

    @Override
    public DxGridTemplate selectGrid(String gridName) {
        GridInfoEntity gridInfoEntity = gridInfoEntityDao.selectByName(gridName);
        if (null != gridInfoEntity) {
            Long gridId = gridInfoEntity.getId();
            List<GridColumnInfoEntity> gridColumnInfoEntityList = gridColumnInfoEntityDao.selectByGridId(gridId);
            GridExtendInfoEntity gridExtendInfoEntity = gridExtendInfoEntityDao.selectByGridId(gridId);
            return getDxGridTemplate(gridId, gridColumnInfoEntityList, gridExtendInfoEntity);
        } else {
            throw new NullPointerException("表格：[ " + gridName + " ]未配置，请联系管理员！");
        }
    }

    /**
     * 构建 DxGridTemplate
     *
     * @param gridColumnInfoEntityList
     * @param gridExtendInfoEntity
     * @return
     */
    private DxGridTemplate getDxGridTemplate(Long gridId, List<GridColumnInfoEntity> gridColumnInfoEntityList, GridExtendInfoEntity gridExtendInfoEntity) {
        DxGridTemplate dxGridTemplate = new DxGridTemplate();
        dxGridTemplate.setGridId(gridId);
        BeanUtils.copyProperties(gridExtendInfoEntity, dxGridTemplate);
        StringBuilder header = new StringBuilder();
        StringBuilder columnIds = new StringBuilder();
        StringBuilder searchTitles = new StringBuilder();
        StringBuilder searchIds = new StringBuilder();
        int i = 0;
        String name;
        byte isSearch;
        for (GridColumnInfoEntity entity : gridColumnInfoEntityList) {
            // name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, entity.getName());
            name = entity.getName();
            isSearch = entity.getIsSearch();
            if (i == 0) {
                header.append(entity.getTitle());
                columnIds.append(name);
                if (isSearch == (byte) 1) {
                    searchTitles.append(entity.getTitle());
                    searchIds.append(name);
                }
            } else {
                header.append(",").append(entity.getTitle());
                columnIds.append(",").append(name);
                if (isSearch == (byte) 1) {
                    searchTitles.append(",").append(entity.getTitle());
                    searchIds.append(",").append(name);
                }
            }
            ++i;
        }
        dxGridTemplate.setSearchIds(searchIds);
        dxGridTemplate.setSearchTitles(searchTitles);
        dxGridTemplate.setHeader(header);
        dxGridTemplate.setColumnIds(columnIds);
        return dxGridTemplate;
    }

}
