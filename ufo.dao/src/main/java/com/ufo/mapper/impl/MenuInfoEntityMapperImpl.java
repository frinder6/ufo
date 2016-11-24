package com.ufo.mapper.impl;

import com.ufo.entity.MenuInfoEntity;
import com.ufo.entity.Page;
import com.ufo.entity.sub.MenuInfoSubEntity;
import com.ufo.vo.MenuTreeInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/17.
 */
public interface MenuInfoEntityMapperImpl {

    List<MenuInfoSubEntity> selectByPid(Long parentId);

    List<MenuTreeInfoVO> selectTreeByPid(Long parentId);

    List<MenuInfoEntity> selectPage(@Param("p") Page page, @Param("e") MenuInfoEntity entity);

    int selectPageCount(@Param("e") MenuInfoEntity entity);

}
