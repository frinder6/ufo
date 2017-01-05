package com.ufo.controller;

import com.ufo.entity.EasyuiGridTemplate;
import com.ufo.init.W2uiGridTemplateLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by frinder6 on 2016/9/26.
 */
@Controller
@RequestMapping("/redirect")
public class RedirectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedirectController.class);


    /**
     * 跳转方法
     * 如果包含 gridName 参数，则加载配置信息返回
     *
     * @param modelMap
     * @param path
     * @return
     */
    @RequestMapping("/{path}/{gridName}")
    public String redirect(ModelMap modelMap, @PathVariable("path") String path, @PathVariable("gridName") String gridName) {
        Map<String, Object> gridInfo = new HashMap() {{
            EasyuiGridTemplate gridTemplate = W2uiGridTemplateLoader.GRIDS.get(gridName.toLowerCase());
            put("gridName", gridName);
            put("addUrl", gridTemplate.getAddUrl());
            put("removeUrl", gridTemplate.getRemoveUrl());
            put("modifyUrl", gridTemplate.getModifyUrl());
        }};
        modelMap.put("gridInfo", gridInfo);
        LOGGER.info("redirect to : " + path);
        LOGGER.info(modelMap.toString());
        return path;
    }

}
