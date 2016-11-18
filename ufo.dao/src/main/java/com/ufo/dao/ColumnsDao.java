package com.ufo.dao;

import com.ufo.vo.ColumnsVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/12.
 */
public interface ColumnsDao {

    @Select({
            "SELECT",
            "COLUMN_NAME, COLUMN_COMMENT",
            "FROM information_schema.`COLUMNS`",
            "WHERE TABLE_SCHEMA = 'ufo' AND TABLE_NAME = #{tableName}"
    })
    @Results({
            @Result(column = "COLUMN_NAME", property = "columnName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "COLUMN_COMMENT", property = "columnComment", jdbcType = JdbcType.VARCHAR)
    })
    List<ColumnsVO> selectByTableName(@Param("tableName") String tableName);

}
