package com.ufo.controller;

import com.ufo.entity.DxDataEntity;
import com.ufo.entity.Value;
import com.ufo.service.MenuService;
import com.ufo.vo.MenuInfoVO;
import com.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frinder6 on 2016/10/16.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    /**
     * 组装前端需要 html
     *
     * @return
     */
    @RequestMapping("/server.menu")
    public Value menu() {
        List<MenuInfoVO> menuInfoVOs = menuService.selectMenu(0L);
        return MenuUtil.MENU_UTIL.menu(menuInfoVOs);
    }


    /**
     * 分页显示 menu 数据
     * @param request
     * @return
     */
    @RequestMapping("/page.menu")
    public DxDataEntity page(HttpServletRequest request) {
        DxDataEntity dx = DxDataEntity.getInstance(request);
        menuService.selectPage(dx, null);
        return dx;
    }


}
