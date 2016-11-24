package com.ufo.service;

import com.ufo.entity.EasyuiFormTemplate;
import com.ufo.entity.GridInfoEntity;
import com.ufo.entity.EasyuiGridTemplate;
import com.ufo.vo.ColumnsVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder6 on 2016/11/3.
 */
public interface GridService {

    EasyuiGridTemplate selectGrid(String gridName) throws NullPointerException;

    List<ColumnsVO> selectColumns(String tableName);

    List<GridInfoEntity> selectPage(GridInfoEntity record);

    void loadValidGridList(Map<String, EasyuiGridTemplate> map) throws Exception;

    void loadValidFormList(Map<String, EasyuiFormTemplate> map) throws Exception;

}
