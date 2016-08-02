package com.ufo.service;

import com.ufo.dao.IDao;
import com.ufo.entity.QueueLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by frinder_liu on 2016/8/2.
 */

@Service
public class QueueLogService extends BaseService<QueueLog> {

    @Autowired
    private IDao<QueueLog> queueLogIDao;

    @Override
    public long insert(QueueLog entity) {
        return this.queueLogIDao.insert(entity);
    }
}
