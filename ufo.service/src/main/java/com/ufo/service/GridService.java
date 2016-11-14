package com.ufo.service;

import com.ufo.entity.DxGridTemplate;
import com.ufo.entity.GridInfoEntity;
import com.ufo.vo.ColumnsVO;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/3.
 */
public interface GridService {

    DxGridTemplate selectGrid(String gridName) throws NullPointerException;

    List<ColumnsVO> selectColumns(String tableName);

    List<GridInfoEntity> selectPage(GridInfoEntity record);

}
