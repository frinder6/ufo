package com.ufo.service;

import com.ufo.mapper.IDao;
import com.ufo.entity.QueueLogEntity;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2016/8/2.
 */

@Service
public class QueueLogService extends BaseService<QueueLogEntity> {

    @Autowired
    private IDao<QueueLogEntity> queueLogDao;

    @Override
    public long insert(SqlEntity<QueueLogEntity> entity) throws SqlFormatException {
        return this.queueLogDao.persist(entity);
    }

    @Override
    public List<QueueLogEntity> selectForList(SqlEntity<QueueLogEntity> entity) throws SqlFormatException {
        return this.queueLogDao.selectForList(entity);
    }
}
