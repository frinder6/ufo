package com.ufo.mapper.impl;

import com.ufo.entity.GridInfoEntity;
import com.ufo.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/19.
 */
public interface GridInfoEntityMapperImpl {

    GridInfoEntity selectByName(String gridName);

    List<GridInfoEntity> selectValidList();

    List<GridInfoEntity> selectPage(@Param("p") Page page, @Param("e") GridInfoEntity entity);

    int selectPageCount(@Param("e") GridInfoEntity entity);

}
