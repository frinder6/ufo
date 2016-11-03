package com.ufo.dao;

import com.ufo.entity.GridInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

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
}
