package com.ufo.service;

import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;

import java.util.List;

/**
 * Created on 2016/8/2.
 */
public interface IService<T> {

    long insert(SqlEntity<T> entity) throws SqlFormatException;

    List<T> selectForList(SqlEntity<T> entity) throws SqlFormatException;

    T selectForSingle(SqlEntity<T> entity) throws SqlFormatException;
}
