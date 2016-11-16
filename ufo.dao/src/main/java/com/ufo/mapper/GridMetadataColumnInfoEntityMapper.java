package com.ufo.mapper;

import com.ufo.entity.GridMetadataColumnInfoEntity;

public interface GridMetadataColumnInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GridMetadataColumnInfoEntity record);

    int insertSelective(GridMetadataColumnInfoEntity record);

    GridMetadataColumnInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridMetadataColumnInfoEntity record);

    int updateByPrimaryKey(GridMetadataColumnInfoEntity record);
}