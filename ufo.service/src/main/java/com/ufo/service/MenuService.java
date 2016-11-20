package com.ufo.service;

import com.ufo.entity.W2uiGridResult;
import com.ufo.entity.MenuInfoEntity;
import com.ufo.entity.sub.MenuInfoSubEntity;
import com.ufo.vo.MenuTreeInfoVO;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/3.
 */
public interface MenuService {

    List<MenuInfoSubEntity> selectMenu(Long pid);

    List<MenuTreeInfoVO> selectTree(Long pid);

    int selectPageCount(MenuInfoEntity entity);

    W2uiGridResult selectPage(MenuInfoSubEntity entity);

    MenuInfoEntity findById(Long id);

    Long insert(MenuInfoEntity record);

    void update(MenuInfoEntity record);

    void delete(Long id);

}
