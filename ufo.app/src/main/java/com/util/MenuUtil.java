package com.util;

import com.ufo.entity.Value;
import com.ufo.entity.sub.MenuInfoSubEntity;

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
     * @param menuInfoSubEntities
     * @return
     */
    public Value menu(List<MenuInfoSubEntity> menuInfoSubEntities) {
        StringBuilder menuStr = new StringBuilder("<ul>");
        for (MenuInfoSubEntity entity : menuInfoSubEntities) {
            menuStr.append(menuNode(entity));
        }
        menuStr.append("</ul>");
        Value value = new Value();
        value.setValue(menuStr);
        return value;
    }


    /**
     * @param entity
     * @return
     */
    private String menuNode(MenuInfoSubEntity entity) {
        StringBuilder menuStr = new StringBuilder();
        String pli = "<li><span>%s - %s</span><ul>";
        String sli = "</ul></li>";
        String li = "<li><a href=\"%s\">%s - %s</a></li>";
        if (null != entity.getChildren() && !entity.getChildren().isEmpty()) {
            menuStr.append(String.format(pli, entity.getId(), entity.getTitle()));
            for (MenuInfoSubEntity subEntity : entity.getChildren()) {
                menuStr.append(menuNode(subEntity));
            }
            menuStr.append(sli);
        } else {
            menuStr.append(String.format(li, entity.getUrl(), entity.getId(), entity.getTitle()));
        }
        return menuStr.toString();
    }

}
