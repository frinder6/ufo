package com.util;

import com.ufo.entity.Value;
import com.ufo.vo.MenuInfoVO;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/5.
 */
public class MenuUtil {

    public static final MenuUtil MENU_UTIL = new MenuUtil();

    private MenuUtil() {
    }

    /**
     * 获取菜单
     *
     * @param menuInfoVOs
     * @return
     */
    public Value menu(List<MenuInfoVO> menuInfoVOs) {
        StringBuilder menuStr = new StringBuilder("<ul>");
        for (MenuInfoVO vo : menuInfoVOs) {
            menuStr.append(menuNode(vo));
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
    private String menuNode(MenuInfoVO vo) {
        StringBuilder menuStr = new StringBuilder();
        String pli = "<li><span>%s - %s</span><ul>";
        String sli = "</ul></li>";
        String li = "<li><a href=\"%s\">%s - %s</a></li>";
        if (null != vo.getChildren() && !vo.getChildren().isEmpty()) {
            menuStr.append(String.format(pli, vo.getId(), vo.getTitle()));
            for (MenuInfoVO svo : vo.getChildren()) {
                menuStr.append(menuNode(svo));
            }
            menuStr.append(sli);
        } else {
            menuStr.append(String.format(li, vo.getUrl(), vo.getId(), vo.getTitle()));
        }
        return menuStr.toString();
    }

}
