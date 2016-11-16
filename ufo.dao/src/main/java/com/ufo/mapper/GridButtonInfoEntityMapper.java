package com.ufo.mapper;

import com.ufo.entity.GridButtonInfoEntity;

public interface GridButtonInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GridButtonInfoEntity record);

    int insertSelective(GridButtonInfoEntity record);

    GridButtonInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridButtonInfoEntity record);

    int updateByPrimaryKey(GridButtonInfoEntity record);
}