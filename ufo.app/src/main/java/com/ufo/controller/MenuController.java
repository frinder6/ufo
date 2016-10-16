package com.ufo.controller;

import com.ufo.vo.MenuInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frinder6 on 2016/10/16.
 */
@Controller
public class MenuController {

    @RequestMapping("/menu")
    public String menu(ModelMap modelMap){
        List<MenuInfoVO> menuList = new ArrayList(){{
            MenuInfoVO vo = new MenuInfoVO(1L, "我的导航", 0L, "");
            add(vo);
            MenuInfoVO vo1 = new MenuInfoVO(2L, "库存管理", 0L, "");
            vo1.setChildren(new ArrayList(){{
                add(new MenuInfoVO(3L, "库存调整", 1L, "www.bbb.com"));
                add(new MenuInfoVO(4L, "渠道库存", 1L, "www.ccc.com"));
                MenuInfoVO dvo = new MenuInfoVO(5L, "档期库存", 1L, "www.ddd.com");
                add(dvo);
                dvo.setChildren(new ArrayList(){{
                    add(new MenuInfoVO(12L, "档期查询", 5L, "www.aaa.com"));
                    add(new MenuInfoVO(13L, "档期调整", 5L, "www.bbb.com"));
                }});
            }});
            add(vo1);
            MenuInfoVO vo2 = new MenuInfoVO(6L, "订单管理", 0L, "");
            vo2.setChildren(new ArrayList(){{
                add(new MenuInfoVO(7L, "占用查询", 6L, "www.aaa.com"));
                add(new MenuInfoVO(8L, "库存查询", 6L, "www.bbb.com"));
            }});
            add(vo2);
            MenuInfoVO vo3 = new MenuInfoVO(9L, "系统管理", 0L, "");
            vo3.setChildren(new ArrayList(){{
                add(new MenuInfoVO(10L, "占用查询", 9L, "www.aaa.com"));
                add(new MenuInfoVO(11L, "库存查询", 9L, "www.bbb.com"));
            }});
            add(vo3);
        }};
        modelMap.addAttribute("menus", menuList);
        return "index";
    }

}
