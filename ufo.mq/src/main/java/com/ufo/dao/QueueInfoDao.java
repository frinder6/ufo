package com.ufo.dao;

import com.ufo.entity.QueueInfoEntity;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frinder_liu on 2016/8/4.
 */
@Service
public class QueueInfoDao extends BaseDao<QueueInfoEntity> {

    private final String TABLE_NAME = "ufo_queue_info";
    private final String[] COLS = {"queue_name", "exchange_name", "routing_key", "exchange_type", "status"};


    @Override
    public long persist(SqlEntity<QueueInfoEntity> entity) throws SqlFormatException {
        setValue(entity, TABLE_NAME, COLS);
        return super.persist(entity);
    }

    @Override
    public List<QueueInfoEntity> selectForList(SqlEntity<QueueInfoEntity> entity) throws SqlFormatException {
        setValue(entity, TABLE_NAME, COLS);
        return super.selectForList(entity);
    }


    @Override
    public QueueInfoEntity selectForSingle(SqlEntity<QueueInfoEntity> entity) throws SqlFormatException {
        setValue(entity, TABLE_NAME, COLS);
        return super.selectForSingle(entity);
    }
}
