package com.ufo.mapper;

import com.ufo.entity.GridExtendInfoEntity;

public interface GridExtendInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GridExtendInfoEntity record);

    int insertSelective(GridExtendInfoEntity record);

    GridExtendInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridExtendInfoEntity record);

    int updateByPrimaryKey(GridExtendInfoEntity record);
}