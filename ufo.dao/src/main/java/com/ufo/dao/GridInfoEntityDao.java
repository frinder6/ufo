package com.ufo.dao;

import com.ufo.entity.GridInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/4.
 */
@Mapper
public interface GridInfoEntityDao {

    @Select({
            "select",
            "id ",
            "from ufo_grid_info",
            "where grid_name = #{gridName,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true)
    })
    GridInfoEntity selectByName(String gridName);


    @Select({
            "select",
            "id, grid_name, status, create_time, creater, update_time, updater",
            "from ufo_grid_info",
            "limit 0, 1000"
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
    List<GridInfoEntity> selectPage(GridInfoEntity record);

}
