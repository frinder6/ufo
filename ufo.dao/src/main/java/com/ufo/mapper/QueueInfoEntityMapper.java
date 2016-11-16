package com.ufo.mapper;

import com.ufo.entity.QueueInfoEntity;

public interface QueueInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QueueInfoEntity record);

    int insertSelective(QueueInfoEntity record);

    QueueInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QueueInfoEntity record);

    int updateByPrimaryKey(QueueInfoEntity record);
}