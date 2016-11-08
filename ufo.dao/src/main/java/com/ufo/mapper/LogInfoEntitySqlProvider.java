package com.ufo.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.ufo.entity.LogInfoEntityWithBLOBs;

public class LogInfoEntitySqlProvider {

    public String insertSelective(LogInfoEntityWithBLOBs record) {
        BEGIN();
        INSERT_INTO("ufo_log_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getHost() != null) {
            VALUES("host", "#{host,jdbcType=VARCHAR}");
        }
        
        if (record.getHandler() != null) {
            VALUES("handler", "#{handler,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestUrl() != null) {
            VALUES("request_url", "#{requestUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestParams() != null) {
            VALUES("request_params", "#{requestParams,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            VALUES("class_name", "#{className,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            VALUES("method", "#{method,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodParams() != null) {
            VALUES("method_params", "#{methodParams,jdbcType=VARCHAR}");
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
        
        if (record.getResult() != null) {
            VALUES("result", "#{result,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getError() != null) {
            VALUES("error", "#{error,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(LogInfoEntityWithBLOBs record) {
        BEGIN();
        UPDATE("ufo_log_info");
        
        if (record.getHost() != null) {
            SET("host = #{host,jdbcType=VARCHAR}");
        }
        
        if (record.getHandler() != null) {
            SET("handler = #{handler,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestUrl() != null) {
            SET("request_url = #{requestUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestParams() != null) {
            SET("request_params = #{requestParams,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            SET("class_name = #{className,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            SET("method = #{method,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodParams() != null) {
            SET("method_params = #{methodParams,jdbcType=VARCHAR}");
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
        
        if (record.getResult() != null) {
            SET("result = #{result,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getError() != null) {
            SET("error = #{error,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }
}