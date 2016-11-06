package com.ufo.controller;

import com.ufo.entity.DxGridResult;
import com.ufo.entity.MenuInfoEntity;
import com.ufo.entity.Value;
import com.ufo.service.MenuService;
import com.ufo.vo.MenuInfoVO;
import com.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by frinder6 on 2016/10/16.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @RequestMapping("/server.menu")
    public Value menu() {
        List<MenuInfoVO> menuInfoVOs = menuService.selectMenu(0L);
        return MenuUtil.MENU_UTIL.menu(menuInfoVOs);
    }


    @RequestMapping("/page.menu")
    public DxGridResult page(MenuInfoEntity entity){
        DxGridResult result = new DxGridResult();
        result.setData(menuService.selectPage(entity));
        return result;
    }


}
