package com.ufo.service;

import com.ufo.dao.IDao;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2016/8/2.
 */

@Service
public class BaseService<T> implements IService<T> {

    @Autowired
    private IDao<T> baseDao;

    @Override
    public long insert(SqlEntity<T> entity) throws SqlFormatException {
        return baseDao.persist(entity);
    }

    @Override
    public List<T> selectForList(SqlEntity<T> entity) throws SqlFormatException {
        return null;
    }

    @Override
    public T selectForSingle(SqlEntity<T> entity) throws SqlFormatException {
        return null;
    }


}
