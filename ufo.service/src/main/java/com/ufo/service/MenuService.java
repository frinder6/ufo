package com.ufo.service;

import com.ufo.vo.MenuInfoVO;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/3.
 */
public interface MenuService {

    List<MenuInfoVO> selectMenu(Long pid);

}
