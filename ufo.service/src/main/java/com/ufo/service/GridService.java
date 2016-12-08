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

    GridExtendInfoEntity getGridExtendInfoByGridId(Long gridId);

    EasyuiGridResult selectPage(Page page, GridInfoEntity entity);

    EasyuiGridResult selectTablePage(Page page);

    EasyuiGridResult selectTableColumnPage(Page page, String tableName, Long gridId);

    EasyuiGridResult selectColumnPage(Page page, GridColumnInfoEntity entity);

    void loadValidGridList(Map<String, EasyuiGridTemplate> map) throws Exception;

    void loadValidFormList(Map<String, EasyuiFormTemplate> map) throws Exception;

    void batchInsertSelective(ColumnsVO columnsVO);

    void insert(GridInfoEntity entity);

    void delete(Long id);

    void update(GridInfoEntity entity);

    void insertExtendEntity(GridExtendInfoEntity entity);

    void deleteExtendEntity(Long id);

    void updateExtendEntity(GridExtendInfoEntity entity);

    void insertColumn(GridColumnInfoEntity entity);

    void deleteColumns(Long id);

    void updateColumn(GridColumnInfoEntity entity);

}
