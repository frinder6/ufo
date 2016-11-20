package com.ufo.mapper.impl;

import com.ufo.entity.GridInfoEntity;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/19.
 */
public interface GridInfoEntityMapperImpl {

    GridInfoEntity selectByName(String gridName);

    List<GridInfoEntity> selectValidList();

}
