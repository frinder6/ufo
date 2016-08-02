package com.ufo.dao;

/**
 * Created by frinder_liu on 2016/8/1.
 */
public interface IDao<T> {
    long insert(T entity);
}
