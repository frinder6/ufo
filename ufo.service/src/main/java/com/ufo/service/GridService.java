package com.ufo.service;

import com.ufo.entity.*;
import com.ufo.vo.ColumnsVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder6 on 2016/11/3.
 */
public interface GridService {

    EasyuiGridTemplate selectGrid(String gridName) throws NullPointerException;

    EasyuiGridResult selectPage(Page page, GridInfoEntity entity);

    EasyuiGridResult selectTablePage(Page page);

    EasyuiGridResult selectTableColumnPage(Page page, String tableName);

    EasyuiGridResult selectColumnPage(Page page, GridColumnInfoEntity entity);

    void loadValidGridList(Map<String, EasyuiGridTemplate> map) throws Exception;

    void loadValidFormList(Map<String, EasyuiFormTemplate> map) throws Exception;

}
