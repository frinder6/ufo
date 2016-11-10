package com.ufo.mapper;

import com.ufo.entity.GridMetadataButtonInfoEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface GridMetadataButtonInfoEntityMapper {
    @Delete({
        "delete from ufo_grid_metadata_button_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ufo_grid_metadata_button_info (id, text, ",
        "title, img, type, ",
        "action, enable, ",
        "create_time, creater, ",
        "update_time, updater)",
        "values (#{id,jdbcType=BIGINT}, #{text,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{img,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{action,jdbcType=VARCHAR}, #{enable,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{creater,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{updater,jdbcType=VARCHAR})"
    })
    int insert(GridMetadataButtonInfoEntity record);

    @InsertProvider(type=GridMetadataButtonInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(GridMetadataButtonInfoEntity record);

    @Select({
        "select",
        "id, text, title, img, type, action, enable, create_time, creater, update_time, ",
        "updater",
        "from ufo_grid_metadata_button_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable", property="enable", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR)
    })
    GridMetadataButtonInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=GridMetadataButtonInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GridMetadataButtonInfoEntity record);

    @Update({
        "update ufo_grid_metadata_button_info",
        "set text = #{text,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "img = #{img,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "action = #{action,jdbcType=VARCHAR},",
          "enable = #{enable,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GridMetadataButtonInfoEntity record);
}