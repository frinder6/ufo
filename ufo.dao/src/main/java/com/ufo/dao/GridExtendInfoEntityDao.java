package com.ufo.dao;

import com.ufo.entity.GridExtendInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by frinder6 on 2016/11/4.
 */
public interface GridExtendInfoEntityDao {

    @Select({
            "select",
            "id, grid_id, image_path, skin, paging_skin ",
            "from ufo_grid_extend_info",
            "where grid_id = #{gridId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="grid_id", property="gridId", jdbcType=JdbcType.BIGINT),
            @Result(column="image_path", property="imagePath", jdbcType=JdbcType.VARCHAR),
            @Result(column="skin", property="skin", jdbcType=JdbcType.VARCHAR),
            @Result(column="paging_skin", property="pagingSkin", jdbcType=JdbcType.VARCHAR)
    })
    GridExtendInfoEntity selectByGridId(Long gridId);

}
