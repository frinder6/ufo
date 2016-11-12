package com.ufo.service.impl;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
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

import java.util.ArrayList;
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
            return getDxGridTemplate(gridColumnInfoEntityList, gridExtendInfoEntity);
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
    private DxGridTemplate getDxGridTemplate(List<GridColumnInfoEntity> gridColumnInfoEntityList, GridExtendInfoEntity gridExtendInfoEntity) {
        DxGridTemplate dxGridTemplate = new DxGridTemplate();
        BeanUtils.copyProperties(gridExtendInfoEntity, dxGridTemplate);
        // 显示列 title
        List<String> header = new ArrayList<>();
        // 与显示列对应列 name
        List<String> columnIds = new ArrayList<>();
        // 搜索列 title
        List<String> searchTitles = new ArrayList<>();
        // 搜索列 type
        List<String> searchTypes = new ArrayList<>();
        // 搜索列 name
        List<String> searchIds = new ArrayList<>();
        // 支持新增 title
        List<String> insertTitles = new ArrayList<>();
        // 支持新增 name
        List<String> insertIds = new ArrayList<>();
        // 支持新增 type
        List<String> insertTypes = new ArrayList<>();
        // 支持更新 title
        List<String> modifyTitles = new ArrayList<>();
        // 支持更新 title
        List<String> modifyIds = new ArrayList<>();
        // 支持更新 type
        List<String> modifyTypes = new ArrayList<>();
        String title, name, type;
        byte isSearch, isInsert, isModify;
        for (GridColumnInfoEntity entity : gridColumnInfoEntityList) {
            title = entity.getTitle();
            type = entity.getType();
            name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, entity.getName());
            isSearch = entity.getIsSearch();
            isInsert = entity.getIsInsert();
            isModify = entity.getIsModify();
            header.add(title);
            columnIds.add(name);
            if (isSearch == (byte) 1) {
                searchTitles.add(title);
                searchIds.add(name);
                searchTypes.add(type);
            }
            if (isInsert == (byte) 1) {
                insertTitles.add(title);
                insertIds.add(name);
                insertTypes.add(type);
            }
            if (isModify == (byte) 1) {
                modifyTitles.add(title);
                modifyIds.add(name);
                modifyTypes.add(type);
            }
        }
        dxGridTemplate.setInsertIds(Joiner.on(",").join(insertIds));
        dxGridTemplate.setInsertTitles(Joiner.on(",").join(insertTitles));
        dxGridTemplate.setInsertTypes(Joiner.on(",").join(insertTypes));
        dxGridTemplate.setModifyIds(Joiner.on(",").join(modifyIds));
        dxGridTemplate.setModifyTitles(Joiner.on(",").join(modifyTitles));
        dxGridTemplate.setModifyTypes(Joiner.on(",").join(modifyTypes));
        dxGridTemplate.setSearchIds(Joiner.on(",").join(searchIds));
        dxGridTemplate.setSearchTitles(Joiner.on(",").join(searchTitles));
        dxGridTemplate.setSearchTypes(Joiner.on(",").join(searchTypes));
        dxGridTemplate.setHeader(Joiner.on(",").join(header));
        dxGridTemplate.setColumnIds(Joiner.on(",").join(columnIds));
        return dxGridTemplate;
    }

}
