package com.ufo.mapper;

import com.ufo.entity.MenuInfoEntity;

public interface MenuInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MenuInfoEntity record);

    int insertSelective(MenuInfoEntity record);

    MenuInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuInfoEntity record);

    int updateByPrimaryKey(MenuInfoEntity record);
}