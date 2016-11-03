package com.ufo.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.ufo.entity.LogInfoEntity;

public class LogInfoEntitySqlProvider {

    public String insertSelective(LogInfoEntity record) {
        BEGIN();
        INSERT_INTO("ufo_log_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getRequestUrl() != null) {
            VALUES("request_url", "#{requestUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getIp() != null) {
            VALUES("ip", "#{ip,jdbcType=VARCHAR}");
        }
        
        if (record.getOper() != null) {
            VALUES("oper", "#{oper,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            VALUES("class_name", "#{className,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            VALUES("method", "#{method,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(LogInfoEntity record) {
        BEGIN();
        UPDATE("ufo_log_info");
        
        if (record.getRequestUrl() != null) {
            SET("request_url = #{requestUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getIp() != null) {
            SET("ip = #{ip,jdbcType=VARCHAR}");
        }
        
        if (record.getOper() != null) {
            SET("oper = #{oper,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            SET("class_name = #{className,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            SET("method = #{method,jdbcType=VARCHAR}");
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