package com.ufo.mapper;

import com.ufo.entity.GridInfoEntity;

public interface GridInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GridInfoEntity record);

    int insertSelective(GridInfoEntity record);

    GridInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridInfoEntity record);

    int updateByPrimaryKey(GridInfoEntity record);
}