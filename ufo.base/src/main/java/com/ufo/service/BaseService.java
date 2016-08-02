package com.ufo.service;

import com.ufo.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by frinder_liu on 2016/8/2.
 */

@Service
public class BaseService<T> implements IService<T> {

    @Autowired
    private IDao<T> baseDao;

    @Override
    public long insert(T entity) {
        return baseDao.insert(entity);
    }
}
