package com.ufo.dao;

import com.ufo.entity.MenuInfoEntity;
import com.ufo.entity.sub.MenuInfoSubEntity;
import com.ufo.vo.MenuInfoVO;
import com.ufo.vo.MenuTreeInfoVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface MenuInfoEntityDao {


    @Select({
            "select",
            "id, title, parent_id, url, icon ",
            "from ufo_menu_info",
            "where status = 1 and parent_id = #{parentId,jdbcType=BIGINT} order by sort"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_id", property = "parentId", jdbcType = JdbcType.BIGINT),
            @Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(property = "children", column = "id", many = @Many(select = "com.ufo.dao.MenuInfoEntityDao.selectByPid"))
    })
    List<MenuInfoVO> selectByPid(Long parentId);


    @Select({
            "select",
            "id, title ",
            "from ufo_menu_info",
            "where status = 1 and parent_id = #{parentId,jdbcType=BIGINT} order by sort"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "title", property = "text", jdbcType = JdbcType.VARCHAR),
            @Result(property = "item", column = "id", many = @Many(select = "com.ufo.dao.MenuInfoEntityDao.selectTreeByPid"))
    })
    List<MenuTreeInfoVO> selectTreeByPid(Long parentId);


    @SelectProvider(type = MenuInfoEntityDaoSqlProvider.class, method = "selectPageSql")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "parent_id", property = "parentId", jdbcType = JdbcType.BIGINT),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sort", property = "sort", jdbcType = JdbcType.TINYINT),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "creater", property = "creater", jdbcType = JdbcType.VARCHAR),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "updater", property = "updater", jdbcType = JdbcType.VARCHAR)
    })
    List<MenuInfoEntity> selectPage(MenuInfoEntity record);

    @SelectProvider(type = MenuInfoEntityDaoSqlProvider.class, method = "selectPageCtSql")
    int selectPageCount(MenuInfoEntity record);


}