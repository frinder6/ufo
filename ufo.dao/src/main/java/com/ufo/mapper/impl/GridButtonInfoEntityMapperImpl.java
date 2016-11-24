package com.ufo.mapper.impl;

import com.ufo.entity.GridButtonInfoEntity;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/22.
 */
public interface GridButtonInfoEntityMapperImpl {

    List<GridButtonInfoEntity> selectByGridId(long gridId);

}
