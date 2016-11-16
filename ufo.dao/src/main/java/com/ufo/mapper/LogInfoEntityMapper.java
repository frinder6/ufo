package com.ufo.mapper;

import com.ufo.entity.LogInfoEntity;
import com.ufo.entity.LogInfoEntityWithBLOBs;

public interface LogInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogInfoEntityWithBLOBs record);

    int insertSelective(LogInfoEntityWithBLOBs record);

    LogInfoEntityWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogInfoEntityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogInfoEntityWithBLOBs record);

    int updateByPrimaryKey(LogInfoEntity record);
}