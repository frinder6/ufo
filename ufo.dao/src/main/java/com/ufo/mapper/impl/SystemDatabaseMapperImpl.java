package com.ufo.mapper.impl;

import com.ufo.entity.GridColumnInfoEntity;
import com.ufo.vo.TableVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/28.
 */
public interface SystemDatabaseMapperImpl {

    @Select({
            "SELECT",
            "COLUMN_NAME, COLUMN_COMMENT",
            "FROM information_schema.`COLUMNS` t1",
            "WHERE TABLE_SCHEMA = 'ufo' AND TABLE_NAME LIKE #{tableName}\"%\"",
            "AND NOT EXISTS ( ",
            "SELECT 1 ",
            "FROM ufo_grid_column_info t2 ",
            "WHERE t1.COLUMN_NAME = t2.field AND t2.grid_id = #{gridId})"
    })
    @Results({
            @Result(column = "COLUMN_NAME", property = "field", jdbcType = JdbcType.VARCHAR),
            @Result(column = "COLUMN_COMMENT", property = "title", jdbcType = JdbcType.VARCHAR)
    })
    List<GridColumnInfoEntity> selectTableColumnPage(@Param("tableName") String tableName, @Param("gridId") Long gridId);


    @Select({"SELECT t.TABLE_NAME, t.TABLE_COMMENT ",
            "FROM information_schema.`TABLES` t ",
            "WHERE t.TABLE_SCHEMA = 'ufo'"})
    @Results({
            @Result(column = "TABLE_NAME", property = "tableName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TABLE_COMMENT", property = "tableComment", jdbcType = JdbcType.VARCHAR)
    })
    List<TableVO> selectTablePage();

}
