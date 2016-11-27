package com.ufo.mapper.impl;

import com.ufo.entity.DictInfoEntity;

import java.util.List;

public interface DictInfoEntityMapperImpl {

    List<DictInfoEntity> selectByName(String name);

}