package com.ufo.service.impl;

import com.ufo.dao.ColumnsDao;
import com.ufo.entity.GridColumnInfoEntity;
import com.ufo.entity.GridExtendInfoEntity;
import com.ufo.entity.GridInfoEntity;
import com.ufo.entity.W2uiGridTemplate;
import com.ufo.mapper.impl.GridColumnInfoEntityMapperImpl;
import com.ufo.mapper.impl.GridExtendInfoEntityMapperImpl;
import com.ufo.mapper.impl.GridInfoEntityMapperImpl;
import com.ufo.service.GridService;
import com.ufo.vo.ColumnsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by frinder6 on 2016/11/3.
 */
@Service("gridService")
public class GridServiceImpl implements GridService {


    @Autowired
    private GridColumnInfoEntityMapperImpl gridColumnInfoEntityMapperImpl;

    @Autowired
    private GridInfoEntityMapperImpl gridInfoEntityMapperImpl;

    @Autowired
    private GridExtendInfoEntityMapperImpl gridExtendInfoEntityMapperImpl;

    @Autowired
    private ColumnsDao columnsDao;


    @Override
    public List<GridInfoEntity> selectPage(GridInfoEntity record) {
        return null;
    }


    @Override
    public List<ColumnsVO> selectColumns(String tableName) {
        return columnsDao.selectByTableName(tableName);
    }


    @Override
    public W2uiGridTemplate selectGrid(String gridName) {
        GridInfoEntity gridInfoEntity = gridInfoEntityMapperImpl.selectByName(gridName);
        if (null != gridInfoEntity) {
            return null;
        } else {
            throw new NullPointerException("表格：[ " + gridName + " ]未配置，请联系管理员！");
        }
    }


    @Override
    public void loadValidGridList(Map<String, W2uiGridTemplate> map) throws Exception {
        List<GridInfoEntity> gridInfoEntityList = gridInfoEntityMapperImpl.selectValidList();
        long gridId;
        GridExtendInfoEntity extendInfoEntity;
        List<GridColumnInfoEntity> columnInfoEntityList;
        W2uiGridTemplate gridTemplate;
        W2uiGridTemplate.Column column;
        for (GridInfoEntity entity : gridInfoEntityList) {
            gridTemplate = new W2uiGridTemplate();
            gridTemplate.setName(entity.getName());
            gridId = entity.getId();
            extendInfoEntity = gridExtendInfoEntityMapperImpl.selectByGridId(gridId);
            BeanUtils.copyProperties(extendInfoEntity, gridTemplate);
            BeanUtils.copyProperties(extendInfoEntity, gridTemplate.getUrl());
            columnInfoEntityList = gridColumnInfoEntityMapperImpl.selectByGridId(gridId);
            for (GridColumnInfoEntity columnInfoEntity : columnInfoEntityList) {
                column = new W2uiGridTemplate.Column();
                BeanUtils.copyProperties(columnInfoEntity, column);
                gridTemplate.getColumns().add(column);
            }
            map.put(entity.getName(), gridTemplate);
        }
    }


}
