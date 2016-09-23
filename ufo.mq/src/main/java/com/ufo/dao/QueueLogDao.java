package com.ufo.dao;

import com.ufo.entity.QueueLogEntity;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;
import org.springframework.stereotype.Repository;

/**
 * Created on 2016/8/1.
 */

@Repository
public class QueueLogDao extends BaseDao<QueueLogEntity> {

    private final String TABLE_NAME = "ufo_queue_log";
    private final String[] COLS = {"host", "queue_name", "exchange_name", "routing_key", "class_name", "context"};

    @Override
    public long persist(SqlEntity<QueueLogEntity> entity) throws SqlFormatException {
        setValue(entity, TABLE_NAME, COLS);
        return super.persist(entity);
    }

}
