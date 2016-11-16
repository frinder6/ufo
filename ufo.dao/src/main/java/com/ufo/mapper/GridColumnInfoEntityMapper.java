package com.ufo.mapper;

import com.ufo.entity.GridColumnInfoEntity;

public interface GridColumnInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GridColumnInfoEntity record);

    int insertSelective(GridColumnInfoEntity record);

    GridColumnInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridColumnInfoEntity record);

    int updateByPrimaryKey(GridColumnInfoEntity record);
}