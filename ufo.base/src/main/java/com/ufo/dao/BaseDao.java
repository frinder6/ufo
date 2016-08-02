package com.ufo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder_liu on 2016/8/1.
 */

@Repository
public class BaseDao<T> {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    /**
     * @param tableName
     * @param entity
     * @param cols
     * @return
     */
    public long persist(String tableName, T entity, String[] cols) {
        String sql = JdbcUtil.SingleFactory.SINGLE.getInsertSql(tableName, cols);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.namedJdbcTemplate.update(sql, paramSource, keyHolder);
        return keyHolder.getKey().longValue();
    }


    /**
     * @param tableName
     * @param id
     * @return
     */
    public int delete(String tableName, long id) {
        String sql = JdbcUtil.SingleFactory.SINGLE.getDeleteSql(tableName);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return this.namedJdbcTemplate.update(sql, paramMap);
    }


    /**
     * @param tableName
     * @param entity
     * @param whereCols
     * @return
     */
    public int deleteWheres(String tableName, T entity, String[] whereCols) {
        String sql = JdbcUtil.SingleFactory.SINGLE.getWheresDeleteSql(tableName, whereCols);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
        return this.namedJdbcTemplate.update(sql, paramSource);
    }


    /**
     * @param tableName
     * @param entity
     * @param valueCols
     * @param whereCols
     * @return
     */
    public int modify(String tableName, T entity, String[] valueCols, String[] whereCols) {
        String sql = JdbcUtil.SingleFactory.SINGLE.getUpdateSql(tableName, valueCols, whereCols);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
        return this.namedJdbcTemplate.update(sql, paramSource);
    }


    /**
     *
     * @param tableName
     * @param entity
     * @param valueCols
     * @param whereCols
     * @return
     */
    public List<T> selectForList(String tableName, T entity, String[] valueCols, String[] whereCols) {
        String sql = JdbcUtil.SingleFactory.SINGLE.getSelectSql(tableName, valueCols, whereCols);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
        return (List<T>) this.namedJdbcTemplate.queryForList(sql, paramSource, entity.getClass());
    }


    /**
     *
     * @param tableName
     * @param entity
     * @param valueCols
     * @param whereCols
     * @return
     */
    public T selectForSingle(String tableName, T entity, String[] valueCols, String[] whereCols){
        String sql = JdbcUtil.SingleFactory.SINGLE.getSelectSql(tableName, valueCols, whereCols);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
        return (T) this.namedJdbcTemplate.queryForObject(sql, paramSource, entity.getClass());
    }

}
