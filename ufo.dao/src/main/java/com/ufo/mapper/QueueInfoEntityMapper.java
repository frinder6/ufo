package com.ufo.mapper;

import com.ufo.entity.QueueInfoEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface QueueInfoEntityMapper {
    @Delete({
        "delete from ufo_queue_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ufo_queue_info (id, queue_name, ",
        "exchange_name, routing_key, ",
        "exchange_type, status, ",
        "create_time, creater, ",
        "update_time, updater)",
        "values (#{id,jdbcType=BIGINT}, #{queueName,jdbcType=VARCHAR}, ",
        "#{exchangeName,jdbcType=VARCHAR}, #{routingKey,jdbcType=VARCHAR}, ",
        "#{exchangeType,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{creater,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{updater,jdbcType=VARCHAR})"
    })
    int insert(QueueInfoEntity record);

    @InsertProvider(type=QueueInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(QueueInfoEntity record);

    @Select({
        "select",
        "id, queue_name, exchange_name, routing_key, exchange_type, status, create_time, ",
        "creater, update_time, updater",
        "from ufo_queue_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="queue_name", property="queueName", jdbcType=JdbcType.VARCHAR),
        @Result(column="exchange_name", property="exchangeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="routing_key", property="routingKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="exchange_type", property="exchangeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR)
    })
    QueueInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=QueueInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QueueInfoEntity record);

    @Update({
        "update ufo_queue_info",
        "set queue_name = #{queueName,jdbcType=VARCHAR},",
          "exchange_name = #{exchangeName,jdbcType=VARCHAR},",
          "routing_key = #{routingKey,jdbcType=VARCHAR},",
          "exchange_type = #{exchangeType,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QueueInfoEntity record);
}