package com.ufo.mapper.impl;

import com.ufo.entity.GridColumnInfoEntity;
import com.ufo.entity.Page;
import com.ufo.vo.ColumnsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GridColumnInfoEntityMapperImpl {

    List<GridColumnInfoEntity> selectByGridId(long gridId);

    List<GridColumnInfoEntity> selectPage(@Param("p") Page page, @Param("e") GridColumnInfoEntity entity);

    int selectPageCount(@Param("e") GridColumnInfoEntity entity);

    void batchInsertSelective(ColumnsVO columnsVO);

}