package com.ufo.mapper;

import com.ufo.entity.LogInfoEntity;
import com.ufo.entity.LogInfoEntityWithBLOBs;
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
        "insert into ufo_log_info (id, host, ",
        "handler, request_url, ",
        "request_params, class_name, ",
        "method, method_params, ",
        "status, create_time, ",
        "creater, update_time, ",
        "updater, result, ",
        "error)",
        "values (#{id,jdbcType=BIGINT}, #{host,jdbcType=VARCHAR}, ",
        "#{handler,jdbcType=VARCHAR}, #{requestUrl,jdbcType=VARCHAR}, ",
        "#{requestParams,jdbcType=VARCHAR}, #{className,jdbcType=VARCHAR}, ",
        "#{method,jdbcType=VARCHAR}, #{methodParams,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{creater,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updater,jdbcType=VARCHAR}, #{result,jdbcType=LONGVARCHAR}, ",
        "#{error,jdbcType=LONGVARCHAR})"
    })
    int insert(LogInfoEntityWithBLOBs record);

    @InsertProvider(type=LogInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(LogInfoEntityWithBLOBs record);

    @Select({
        "select",
        "id, host, handler, request_url, request_params, class_name, method, method_params, ",
        "status, create_time, creater, update_time, updater, result, error",
        "from ufo_log_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="host", property="host", jdbcType=JdbcType.VARCHAR),
        @Result(column="handler", property="handler", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_url", property="requestUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_params", property="requestParams", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_params", property="methodParams", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR),
        @Result(column="result", property="result", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="error", property="error", jdbcType=JdbcType.LONGVARCHAR)
    })
    LogInfoEntityWithBLOBs selectByPrimaryKey(Long id);

    @UpdateProvider(type=LogInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LogInfoEntityWithBLOBs record);

    @Update({
        "update ufo_log_info",
        "set host = #{host,jdbcType=VARCHAR},",
          "handler = #{handler,jdbcType=VARCHAR},",
          "request_url = #{requestUrl,jdbcType=VARCHAR},",
          "request_params = #{requestParams,jdbcType=VARCHAR},",
          "class_name = #{className,jdbcType=VARCHAR},",
          "method = #{method,jdbcType=VARCHAR},",
          "method_params = #{methodParams,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR},",
          "result = #{result,jdbcType=LONGVARCHAR},",
          "error = #{error,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(LogInfoEntityWithBLOBs record);

    @Update({
        "update ufo_log_info",
        "set host = #{host,jdbcType=VARCHAR},",
          "handler = #{handler,jdbcType=VARCHAR},",
          "request_url = #{requestUrl,jdbcType=VARCHAR},",
          "request_params = #{requestParams,jdbcType=VARCHAR},",
          "class_name = #{className,jdbcType=VARCHAR},",
          "method = #{method,jdbcType=VARCHAR},",
          "method_params = #{methodParams,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LogInfoEntity record);
}