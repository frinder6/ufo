package com.ufo.mapper.impl;

import com.ufo.entity.GridColumnInfoEntity;

import java.util.List;

public interface GridColumnInfoEntityMapperImpl {

    List<GridColumnInfoEntity> selectByGridId(long gridId);

}