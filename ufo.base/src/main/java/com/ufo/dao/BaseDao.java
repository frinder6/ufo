package com.ufo.dao;

import com.ufo.entity.Page;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2016/8/1.
 */

@Repository
public class BaseDao<T> implements IDao<T> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    /**
     * @param entity
     * @return
     * @throws SqlFormatException
     */
    public long persist(SqlEntity<T> entity) throws SqlFormatException {
        String sql = JdbcUtil.SingleFactory.SINGLE.getInsertSql(entity);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity.getEntity());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.namedJdbcTemplate.update(sql, paramSource, keyHolder);
        return keyHolder.getKey().longValue();
    }


    /**
     * @param entity
     * @return
     */
    public int delete(SqlEntity<T> entity) {
        String sql = JdbcUtil.SingleFactory.SINGLE.getDeleteSql(entity.getTableName());
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity.getEntity());
        return this.namedJdbcTemplate.update(sql, paramSource);
    }


    /**
     * @param entity
     * @return
     */
    public int deleteWheres(SqlEntity<T> entity) {
        String sql = JdbcUtil.SingleFactory.SINGLE.getWheresDeleteSql(entity);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity.getEntity());
        return this.namedJdbcTemplate.update(sql, paramSource);
    }


    /**
     * @param entity
     * @return
     * @throws SqlFormatException
     */
    public int modify(SqlEntity<T> entity) throws SqlFormatException {
        String sql = JdbcUtil.SingleFactory.SINGLE.getUpdateSql(entity);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity.getEntity());
        return this.namedJdbcTemplate.update(sql, paramSource);
    }


    /**
     * @param entity
     * @return
     * @throws SqlFormatException
     */
    public List<T> selectForList(SqlEntity<T> entity) throws SqlFormatException {
        String sql = JdbcUtil.SingleFactory.SINGLE.getSelectSql(entity);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity.getEntity());
        try {
            return (List<T>) this.namedJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(entity.getEntityType()));
        } catch (DataAccessException e) {
            return null;
        }
    }


    /**
     * @param entity
     * @return
     * @throws SqlFormatException
     */
    public T selectForSingle(SqlEntity<T> entity) throws SqlFormatException {
        String sql = JdbcUtil.SingleFactory.SINGLE.getSelectSql(entity);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity.getEntity());
        try {
            return (T) this.namedJdbcTemplate.queryForObject(sql, paramSource, new BeanPropertyRowMapper(entity.getEntityType()));
        } catch (DataAccessException e) {
            return null;
        }
    }


    /**
     * @param entity
     * @param page
     * @return
     * @throws SqlFormatException
     */
    public List<T> selectPage(SqlEntity<T> entity, Page page) throws SqlFormatException {
        String sql = JdbcUtil.SingleFactory.SINGLE.getPageSelectSql(entity, page);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity.getEntity());
        try {
            return this.namedJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(entity.getEntityType()));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    /**
     * @param entity
     * @param tableName
     * @param cols
     */
    public void setValue(SqlEntity<T> entity, String tableName, String[] cols) {
        entity.setTableName(tableName);
        entity.setValueCols(Arrays.asList(cols));
    }

}
