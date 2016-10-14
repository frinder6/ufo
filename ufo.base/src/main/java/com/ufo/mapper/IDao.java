package com.ufo.mapper;

import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;

import java.util.List;

/**
 * Created on 2016/8/1.
 */
public interface IDao<T> {

    long persist(SqlEntity<T> entity) throws SqlFormatException;

    List<T> selectForList(SqlEntity<T> entity) throws SqlFormatException;

    T selectForSingle(SqlEntity<T> entity) throws SqlFormatException;

}
