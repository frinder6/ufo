package com.ufo.dao;

import com.ufo.entity.QueueLog;
import org.springframework.stereotype.Repository;

/**
 * Created by frinder_liu on 2016/8/1.
 */

@Repository
public class QueueLogDao extends BaseDao<QueueLog> implements IDao<QueueLog> {

    private final String TABLENAME = "ufo_queue_log";
    private final String[] COLS = {"ip", "queue_name", "exchange_name", "routing_key", "class_name", "context"};

    @Override
    public long insert(QueueLog entity) {
        return this.persist(TABLENAME, entity, COLS);
    }

}
