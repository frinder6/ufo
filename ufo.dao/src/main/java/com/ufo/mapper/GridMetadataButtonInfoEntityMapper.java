package com.ufo.mapper;

import com.ufo.entity.GridMetadataButtonInfoEntity;

public interface GridMetadataButtonInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GridMetadataButtonInfoEntity record);

    int insertSelective(GridMetadataButtonInfoEntity record);

    GridMetadataButtonInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridMetadataButtonInfoEntity record);

    int updateByPrimaryKey(GridMetadataButtonInfoEntity record);
}