package com.ufo.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.ufo.entity.QueueInfoEntity;

public class QueueInfoEntitySqlProvider {

    public String insertSelective(QueueInfoEntity record) {
        BEGIN();
        INSERT_INTO("ufo_queue_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getQueueName() != null) {
            VALUES("queue_name", "#{queueName,jdbcType=VARCHAR}");
        }
        
        if (record.getExchangeName() != null) {
            VALUES("exchange_name", "#{exchangeName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutingKey() != null) {
            VALUES("routing_key", "#{routingKey,jdbcType=VARCHAR}");
        }
        
        if (record.getExchangeType() != null) {
            VALUES("exchange_type", "#{exchangeType,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(QueueInfoEntity record) {
        BEGIN();
        UPDATE("ufo_queue_info");
        
        if (record.getQueueName() != null) {
            SET("queue_name = #{queueName,jdbcType=VARCHAR}");
        }
        
        if (record.getExchangeName() != null) {
            SET("exchange_name = #{exchangeName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutingKey() != null) {
            SET("routing_key = #{routingKey,jdbcType=VARCHAR}");
        }
        
        if (record.getExchangeType() != null) {
            SET("exchange_type = #{exchangeType,jdbcType=VARCHAR}");
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