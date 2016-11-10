package com.ufo.service;

import com.ufo.entity.MenuInfoEntity;
import com.ufo.vo.MenuInfoVO;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/3.
 */
public interface MenuService {

    List<MenuInfoVO> selectMenu(Long pid);

    List<MenuInfoEntity> selectPage(MenuInfoEntity entity);

    MenuInfoEntity findById(Long id);

    Long insert(MenuInfoEntity record);

    void update(MenuInfoEntity record);

    void delete(Long id);

}
