package com.ufo.mapper;

import com.ufo.entity.GridInfoEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GridInfoEntityMapper {
    @Delete({
        "delete from ufo_grid_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ufo_grid_info (id, grid_name, ",
        "status, create_time, ",
        "creater, update_time, ",
        "updater)",
        "values (#{id,jdbcType=BIGINT}, #{gridName,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{creater,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updater,jdbcType=VARCHAR})"
    })
    int insert(GridInfoEntity record);

    @InsertProvider(type=GridInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(GridInfoEntity record);

    @Select({
        "select",
        "id, grid_name, status, create_time, creater, update_time, updater",
        "from ufo_grid_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="grid_name", property="gridName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater", property="creater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR)
    })
    GridInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=GridInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GridInfoEntity record);

    @Update({
        "update ufo_grid_info",
        "set grid_name = #{gridName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GridInfoEntity record);
}