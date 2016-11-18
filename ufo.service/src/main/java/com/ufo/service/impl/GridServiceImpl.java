package com.ufo.service.impl;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.ufo.dao.ColumnsDao;
import com.ufo.dao.GridColumnInfoEntityDao;
import com.ufo.dao.GridExtendInfoEntityDao;
import com.ufo.dao.GridInfoEntityDao;
import com.ufo.entity.DxGridTemplate;
import com.ufo.entity.GridColumnInfoEntity;
import com.ufo.entity.GridExtendInfoEntity;
import com.ufo.entity.GridInfoEntity;
import com.ufo.service.GridService;
import com.ufo.vo.ColumnsVO;
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

    @Autowired
    private ColumnsDao columnsDao;


    @Override
    public List<GridInfoEntity> selectPage(GridInfoEntity record) {
        return gridInfoEntityDao.selectPage(record);
    }


    @Override
    public List<ColumnsVO> selectColumns(String tableName) {
        return columnsDao.selectByTableName(tableName);
    }

    @Override
    public DxGridTemplate selectGrid(String gridName) {
        GridInfoEntity gridInfoEntity = gridInfoEntityDao.selectByName(gridName);
        if (null != gridInfoEntity) {
            return null;
        } else {
            throw new NullPointerException("表格：[ " + gridName + " ]未配置，请联系管理员！");
        }
    }



}
