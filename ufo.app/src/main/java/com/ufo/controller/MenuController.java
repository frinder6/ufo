package com.ufo.controller;

import com.ufo.entity.*;
import com.ufo.entity.sub.MenuInfoSubEntity;
import com.ufo.service.MenuService;
import com.ufo.entity.EasyuiTreeTemplate;
import com.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by frinder6 on 2016/10/16.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    private MenuService menuService;


    @RequestMapping("/server.menu")
    public Value menu() {
        List<MenuInfoSubEntity> menuInfoVOs = menuService.selectMenu(1L);
        return MenuUtil.MENU_UTIL.menu(menuInfoVOs);
    }

    @RequestMapping("/server.tree")
    public List<EasyuiTreeTemplate> tree() {
        List<EasyuiTreeTemplate> treeTemplateList = menuService.selectTree(0L);
        return treeTemplateList;
    }

    @RequestMapping("/page.menus")
    public EasyuiGridResult page(MenuInfoEntity entity) {
        Page page = Page.getInstance(request);
        return menuService.selectPage(page, entity);
    }

    @RequestMapping("/get.id")
    public MenuInfoEntity get(@RequestParam("id") Long id) {
        return menuService.findById(id);
    }


    @RequestMapping("/add.menu")
    public EasyuiResponse insert(MenuInfoEntity entity) {
        entity.setCreateTime(new Date());
        menuService.insert(entity);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "添加成功！");
    }

    @RequestMapping("/update.menu")
    public EasyuiResponse modify(MenuInfoEntity entity) {
        // menuService.update(entity);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "更新成功！");
    }

    @RequestMapping("/remove.menu")
    public EasyuiResponse remove(@RequestParam("id") Long id) {
        // menuService.delete(id);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "更新成功！");
    }

}
