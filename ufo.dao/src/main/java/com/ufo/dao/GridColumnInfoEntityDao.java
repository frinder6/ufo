package com.ufo.dao;

import com.ufo.entity.GridColumnInfoEntity;
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
public interface GridColumnInfoEntityDao {

    @Select({
            "select",
            "id, title, name ",
            "from ufo_grid_column_info",
            "where grid_id = #{gridId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR)
    })
    List<GridColumnInfoEntity> selectByGridId(Long gridId);

}
