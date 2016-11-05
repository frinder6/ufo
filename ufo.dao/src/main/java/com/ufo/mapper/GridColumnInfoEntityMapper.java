package com.ufo.mapper;

import com.ufo.entity.GridColumnInfoEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface GridColumnInfoEntityMapper {
    @Delete({
        "delete from ufo_grid_column_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ufo_grid_column_info (id, grid_id, ",
        "data_id, title, name, ",
        "is_search, status, ",
        "create_time, creater, ",
        "update_time, updater)",
        "values (#{id,jdbcType=BIGINT}, #{gridId,jdbcType=BIGINT}, ",
        "#{dataId,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{isSearch,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{creater,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{updater,jdbcType=VARCHAR})"
    })
    int insert(GridColumnInfoEntity record);

    @InsertProvider(type=GridColumnInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(GridColumnInfoEntity record);

    @Select({
        "select",
        "id, grid_id, data_id, title, name, is_search, status, create_time, creater, ",
        "update_time, updater",
        "from ufo_grid_column_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="grid_id", property="gridId", jdbcType=JdbcType.BIGINT),
        @Result(column="data_id", property="dataId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_search", property="isSearch", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR)
    })
    GridColumnInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=GridColumnInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GridColumnInfoEntity record);

    @Update({
        "update ufo_grid_column_info",
        "set grid_id = #{gridId,jdbcType=BIGINT},",
          "data_id = #{dataId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "is_search = #{isSearch,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GridColumnInfoEntity record);
}