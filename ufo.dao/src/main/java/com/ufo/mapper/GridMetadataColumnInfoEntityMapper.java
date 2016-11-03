package com.ufo.mapper;

import com.ufo.entity.GridMetadataColumnInfoEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface GridMetadataColumnInfoEntityMapper {
    @Delete({
        "delete from ufo_grid_metadata_column_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ufo_grid_metadata_column_info (id, title, ",
        "name, status, create_time, ",
        "creater, update_time, ",
        "updater)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{creater,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updater,jdbcType=VARCHAR})"
    })
    int insert(GridMetadataColumnInfoEntity record);

    @InsertProvider(type=GridMetadataColumnInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(GridMetadataColumnInfoEntity record);

    @Select({
        "select",
        "id, title, name, status, create_time, creater, update_time, updater",
        "from ufo_grid_metadata_column_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR)
    })
    GridMetadataColumnInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=GridMetadataColumnInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GridMetadataColumnInfoEntity record);

    @Update({
        "update ufo_grid_metadata_column_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GridMetadataColumnInfoEntity record);
}