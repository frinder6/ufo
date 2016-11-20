package com.ufo.service;

import com.ufo.entity.GridInfoEntity;
import com.ufo.entity.W2uiGridTemplate;
import com.ufo.vo.ColumnsVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder6 on 2016/11/3.
 */
public interface GridService {

    W2uiGridTemplate selectGrid(String gridName) throws NullPointerException;

    List<ColumnsVO> selectColumns(String tableName);

    List<GridInfoEntity> selectPage(GridInfoEntity record);

    void loadValidGridList(Map<String, W2uiGridTemplate> map) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, Exception;

}
