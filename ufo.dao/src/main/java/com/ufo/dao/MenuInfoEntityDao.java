package com.ufo.dao;

import com.ufo.entity.DxDataEntity;
import com.ufo.entity.MenuInfoEntity;
import com.ufo.vo.MenuInfoVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

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
            " ${dx.cols} ",
            "from ufo_menu_info",
            "limit #{dx.from}, #{dx.to}"
    })
    List<Map<String, Object>> selectPage(@Param("dx") DxDataEntity dx, @Param("entity") MenuInfoEntity entity);

    @Select({
            "select",
            "count(1)",
            "from ufo_menu_info"
    })
    int selectCount(@Param("dx") DxDataEntity dx, @Param("entity") MenuInfoEntity entity);

}