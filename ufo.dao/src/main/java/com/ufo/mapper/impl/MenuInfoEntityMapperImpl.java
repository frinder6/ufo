package com.ufo.mapper.impl;

import com.ufo.entity.MenuInfoEntity;
import com.ufo.entity.sub.MenuInfoSubEntity;
import com.ufo.vo.MenuTreeInfoVO;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/17.
 */
public interface MenuInfoEntityMapperImpl {

    List<MenuInfoSubEntity> selectByPid(Long parentId);

    List<MenuTreeInfoVO> selectTreeByPid(Long parentId);

    List<MenuInfoEntity> selectPage(MenuInfoSubEntity entity);

    int selectPageCount(MenuInfoEntity entity);

}
