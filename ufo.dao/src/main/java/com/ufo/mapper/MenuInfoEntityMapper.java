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
        "insert into ufo_menu_info (id, name, ",
        "parent_id, url, icon, ",
        "status, sort, creater, ",
        "create_time, modifier, ",
        "update_time)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=BIGINT}, #{url,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{sort,jdbcType=TINYINT}, #{creater,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{modifier,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(MenuInfoEntity record);

    @InsertProvider(type=MenuInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(MenuInfoEntity record);

    @Select({
        "select",
        "id, name, parent_id, url, icon, status, sort, creater, create_time, modifier, ",
        "update_time",
        "from ufo_menu_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifier", property="modifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    MenuInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=MenuInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MenuInfoEntity record);

    @Update({
        "update ufo_menu_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=BIGINT},",
          "url = #{url,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "sort = #{sort,jdbcType=TINYINT},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "modifier = #{modifier,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MenuInfoEntity record);
}