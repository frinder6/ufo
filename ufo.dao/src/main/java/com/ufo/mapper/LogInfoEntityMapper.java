package com.ufo.mapper;

import com.ufo.entity.LogInfoEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface LogInfoEntityMapper {
    @Delete({
        "delete from ufo_log_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ufo_log_info (id, request_url, ",
        "ip, oper, class_name, ",
        "method, status, ",
        "create_time, creater, ",
        "update_time, updater)",
        "values (#{id,jdbcType=BIGINT}, #{requestUrl,jdbcType=VARCHAR}, ",
        "#{ip,jdbcType=VARCHAR}, #{oper,jdbcType=VARCHAR}, #{className,jdbcType=VARCHAR}, ",
        "#{method,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{creater,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{updater,jdbcType=VARCHAR})"
    })
    int insert(LogInfoEntity record);

    @InsertProvider(type=LogInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(LogInfoEntity record);

    @Select({
        "select",
        "id, request_url, ip, oper, class_name, method, status, create_time, creater, ",
        "update_time, updater",
        "from ufo_log_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="request_url", property="requestUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper", property="oper", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR)
    })
    LogInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=LogInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LogInfoEntity record);

    @Update({
        "update ufo_log_info",
        "set request_url = #{requestUrl,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "oper = #{oper,jdbcType=VARCHAR},",
          "class_name = #{className,jdbcType=VARCHAR},",
          "method = #{method,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LogInfoEntity record);
}