package com.ufo.mapper;

import com.ufo.entity.MenuInfoEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface MenuInfoEntityMapper {
    @Delete({
        "delete from ufo_menu_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ufo_menu_info (id, parent_id, ",
        "title, url, icon, ",
        "sort, status, create_time, ",
        "creater, update_time, ",
        "updater)",
        "values (#{id,jdbcType=BIGINT}, #{parentId,jdbcType=BIGINT}, ",
        "#{title,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{creater,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updater,jdbcType=VARCHAR})"
    })
    int insert(MenuInfoEntity record);

    @InsertProvider(type=MenuInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(MenuInfoEntity record);

    @Select({
        "select",
        "id, parent_id, title, url, icon, sort, status, create_time, creater, update_time, ",
        "updater",
        "from ufo_menu_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR)
    })
    MenuInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=MenuInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MenuInfoEntity record);

    @Update({
        "update ufo_menu_info",
        "set parent_id = #{parentId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MenuInfoEntity record);
}