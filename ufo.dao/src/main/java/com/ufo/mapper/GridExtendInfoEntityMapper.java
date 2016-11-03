package com.ufo.mapper;

import com.ufo.entity.GridExtendInfoEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface GridExtendInfoEntityMapper {
    @Delete({
        "delete from ufo_grid_extend_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ufo_grid_extend_info (id, grid_id, ",
        "image_path, skin, ",
        "paging_skin, status, ",
        "create_time, creater, ",
        "update_time, updater)",
        "values (#{id,jdbcType=BIGINT}, #{gridId,jdbcType=BIGINT}, ",
        "#{imagePath,jdbcType=VARCHAR}, #{skin,jdbcType=VARCHAR}, ",
        "#{pagingSkin,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{creater,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{updater,jdbcType=VARCHAR})"
    })
    int insert(GridExtendInfoEntity record);

    @InsertProvider(type=GridExtendInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(GridExtendInfoEntity record);

    @Select({
        "select",
        "id, grid_id, image_path, skin, paging_skin, status, create_time, creater, update_time, ",
        "updater",
        "from ufo_grid_extend_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="grid_id", property="gridId", jdbcType=JdbcType.BIGINT),
        @Result(column="image_path", property="imagePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="skin", property="skin", jdbcType=JdbcType.VARCHAR),
        @Result(column="paging_skin", property="pagingSkin", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR)
    })
    GridExtendInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=GridExtendInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GridExtendInfoEntity record);

    @Update({
        "update ufo_grid_extend_info",
        "set grid_id = #{gridId,jdbcType=BIGINT},",
          "image_path = #{imagePath,jdbcType=VARCHAR},",
          "skin = #{skin,jdbcType=VARCHAR},",
          "paging_skin = #{pagingSkin,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GridExtendInfoEntity record);
}