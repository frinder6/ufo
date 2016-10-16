package com.ufo.controller;

import com.ufo.entity.Value;
import com.ufo.vo.MenuInfoVO;
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

    static List<MenuInfoVO> menuList = new ArrayList() {{
        MenuInfoVO vo = new MenuInfoVO(1L, "我的导航", 0L, "");
        add(vo);
        MenuInfoVO vo1 = new MenuInfoVO(2L, "库存管理", 0L, "");
        vo1.setChildren(new ArrayList() {{
            add(new MenuInfoVO(3L, "库存调整", 1L, "www.bbb.com"));
            add(new MenuInfoVO(4L, "渠道库存", 1L, "www.ccc.com"));
            MenuInfoVO dvo = new MenuInfoVO(5L, "档期库存", 1L, "www.ddd.com");
            add(dvo);
            dvo.setChildren(new ArrayList() {{
                add(new MenuInfoVO(12L, "档期查询", 5L, "www.aaa.com"));
                add(new MenuInfoVO(13L, "档期调整", 5L, "www.bbb.com"));
            }});
        }});
        add(vo1);
        MenuInfoVO vo2 = new MenuInfoVO(6L, "订单管理", 0L, "");
        vo2.setChildren(new ArrayList() {{
            add(new MenuInfoVO(7L, "占用查询", 6L, "www.aaa.com"));
            add(new MenuInfoVO(8L, "库存查询", 6L, "www.bbb.com"));
        }});
        add(vo2);
        MenuInfoVO vo3 = new MenuInfoVO(9L, "系统管理", 0L, "");
        vo3.setChildren(new ArrayList() {{
            add(new MenuInfoVO(10L, "占用查询", 9L, "www.aaa.com"));
            add(new MenuInfoVO(11L, "库存查询", 9L, "www.bbb.com"));
        }});
        add(vo3);
    }};

    /**
     * 将注释换为 @Controller，
     * 并去掉 @RequestMapping("/menu") 再测试该方法
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/ftl.menu")
    public String menu(ModelMap modelMap) {
        modelMap.addAttribute("menus", menuList);
        return "index";
    }

    @RequestMapping("/server.menu")
    public Value menu() {
        StringBuilder menuStr = new StringBuilder("<ul>");
        for (MenuInfoVO vo : menuList) {
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
            menuStr.append(String.format(pli, vo.getId(), vo.getText()));
            for (MenuInfoVO svo : vo.getChildren()) {
                menuStr.append(getMenuNode(svo));
            }
            menuStr.append(sli);
        } else {
            menuStr.append(String.format(li, vo.getUrl(), vo.getId(), vo.getText()));
        }
        return menuStr.toString();
    }

    public static void main(String[] args) {
        MenuController controller = new MenuController();
        System.out.println(controller.menu());
    }


}
