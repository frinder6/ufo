package com.ufo.service;

import com.ufo.mapper.IDao;
import com.ufo.entity.QueueInfoEntity;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frinder_liu on 2016/8/5.
 */

@Service
public class QueueInfoService extends BaseService<QueueInfoEntity> {

    @Autowired
    private IDao<QueueInfoEntity> queueInfoDao;

    @Override
    public List<QueueInfoEntity> selectForList(SqlEntity<QueueInfoEntity> entity) throws SqlFormatException {
        return this.queueInfoDao.selectForList(entity);
    }


    @Override
    public QueueInfoEntity selectForSingle(SqlEntity<QueueInfoEntity> entity) throws SqlFormatException {
        return this.queueInfoDao.selectForSingle(entity);
    }
}
