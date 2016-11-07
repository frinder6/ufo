package com.ufo.service.impl;

import com.ufo.entity.LogInfoEntity;
import com.ufo.mapper.LogInfoEntityMapper;
import com.ufo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by frinder6 on 2016/11/7.
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogInfoEntityMapper logInfoEntityMapper;

    @Override
    public void insert(LogInfoEntity record) {
        logInfoEntityMapper.insertSelective(record);
    }

}
