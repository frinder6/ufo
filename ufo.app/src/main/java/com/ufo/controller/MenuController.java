package com.ufo.controller;

import com.ufo.entity.*;
import com.ufo.entity.sub.MenuInfoSubEntity;
import com.ufo.service.MenuService;
import com.ufo.vo.MenuTreeInfoVO;
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
    public MenuTreeInfoVO tree() {
        MenuTreeInfoVO treeInfoVO = new MenuTreeInfoVO();
        treeInfoVO.setId(0L);
        List<MenuTreeInfoVO> treeInfoVOs = menuService.selectTree(0L);
        treeInfoVO.setItem(treeInfoVOs);
        return treeInfoVO;
    }

    @RequestMapping("/page.menu")
    public W2uiGridResult page() {
        W2uiSearchRequest searchRequest = W2uiRequestFactory.getSearchRequest(request);
        MenuInfoSubEntity entity = searchRequest.convert2Object(MenuInfoSubEntity.class);
        return menuService.selectPage(entity);
    }

    @RequestMapping("/get.id")
    public MenuInfoEntity get(@RequestParam("id") Long id) {
        return menuService.findById(id);
    }


    @RequestMapping("/add.menu")
    public W2uiResponse insert() {
        W2uiAddRequest addRequest = W2uiRequestFactory.getAddRequest(request);
        MenuInfoEntity entity = addRequest.convert2Object(MenuInfoEntity.class);
        entity.setCreateTime(new Date());
        // menuService.insert(entity);
        return new W2uiResponse(W2uiResponse.SUCCESS, "添加成功！");
    }

    @RequestMapping("/update.menu")
    public Value modify(MenuInfoEntity entity) {
        menuService.update(entity);
        return new Value("更新成功！");
    }

    @RequestMapping("/remove.menu")
    public Value remove(@RequestParam("id") Long id) {
        menuService.delete(id);
        return new Value("删除成功！");
    }

}
