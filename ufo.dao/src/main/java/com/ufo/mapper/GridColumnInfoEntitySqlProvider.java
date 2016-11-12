package com.ufo.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.ufo.entity.GridColumnInfoEntity;

public class GridColumnInfoEntitySqlProvider {

    public String insertSelective(GridColumnInfoEntity record) {
        BEGIN();
        INSERT_INTO("ufo_grid_column_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getGridId() != null) {
            VALUES("grid_id", "#{gridId,jdbcType=BIGINT}");
        }
        
        if (record.getDataId() != null) {
            VALUES("data_id", "#{dataId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            VALUES("value", "#{value,jdbcType=VARCHAR}");
        }
        
        if (record.getValidate() != null) {
            VALUES("validate", "#{validate,jdbcType=VARCHAR}");
        }
        
        if (record.getRequired() != null) {
            VALUES("required", "#{required,jdbcType=TINYINT}");
        }
        
        if (record.getIsSearch() != null) {
            VALUES("is_search", "#{isSearch,jdbcType=TINYINT}");
        }
        
        if (record.getIsInsert() != null) {
            VALUES("is_insert", "#{isInsert,jdbcType=TINYINT}");
        }
        
        if (record.getIsModify() != null) {
            VALUES("is_modify", "#{isModify,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreater() != null) {
            VALUES("creater", "#{creater,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdater() != null) {
            VALUES("updater", "#{updater,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(GridColumnInfoEntity record) {
        BEGIN();
        UPDATE("ufo_grid_column_info");
        
        if (record.getGridId() != null) {
            SET("grid_id = #{gridId,jdbcType=BIGINT}");
        }
        
        if (record.getDataId() != null) {
            SET("data_id = #{dataId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            SET("value = #{value,jdbcType=VARCHAR}");
        }
        
        if (record.getValidate() != null) {
            SET("validate = #{validate,jdbcType=VARCHAR}");
        }
        
        if (record.getRequired() != null) {
            SET("required = #{required,jdbcType=TINYINT}");
        }
        
        if (record.getIsSearch() != null) {
            SET("is_search = #{isSearch,jdbcType=TINYINT}");
        }
        
        if (record.getIsInsert() != null) {
            SET("is_insert = #{isInsert,jdbcType=TINYINT}");
        }
        
        if (record.getIsModify() != null) {
            SET("is_modify = #{isModify,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreater() != null) {
            SET("creater = #{creater,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdater() != null) {
            SET("updater = #{updater,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }
}