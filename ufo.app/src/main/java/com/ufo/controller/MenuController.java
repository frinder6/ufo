package com.ufo.controller;

import com.ufo.entity.Value;
import com.ufo.service.MenuService;
import com.ufo.vo.MenuInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping("/server.menu")
    public Value menu() {
        List<MenuInfoVO> menuInfoVOs = menuService.selectMenu(0L);
        return getMenu(menuInfoVOs);
    }

    /**
     * 获取菜单
     *
     * @param menuInfoVOs
     * @return
     */
    private Value getMenu(List<MenuInfoVO> menuInfoVOs) {
        StringBuilder menuStr = new StringBuilder("<ul>");
        for (MenuInfoVO vo : menuInfoVOs) {
            menuStr.append(getMenuNode(vo));
        }
        menuStr.append("</ul>");
        Value value = new Value();
        value.setValue(menuStr);
        return value;
    }


    /**
     * @param vo
     * @return
     */
    private String getMenuNode(MenuInfoVO vo) {
        StringBuilder menuStr = new StringBuilder();
        String pli = "<li><span>%s - %s</span><ul>";
        String sli = "</ul></li>";
        String li = "<li><a href=\"%s\">%s - %s</a></li>";
        if (null != vo.getChildren() && !vo.getChildren().isEmpty()) {
            menuStr.append(String.format(pli, vo.getId(), vo.getTitle()));
            for (MenuInfoVO svo : vo.getChildren()) {
                menuStr.append(getMenuNode(svo));
            }
            menuStr.append(sli);
        } else {
            menuStr.append(String.format(li, vo.getUrl(), vo.getId(), vo.getTitle()));
        }
        return menuStr.toString();
    }


}
