package com.ufo.mapper;

import com.ufo.entity.DictInfoEntity;

public interface DictInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DictInfoEntity record);

    int insertSelective(DictInfoEntity record);

    DictInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DictInfoEntity record);

    int updateByPrimaryKey(DictInfoEntity record);
}