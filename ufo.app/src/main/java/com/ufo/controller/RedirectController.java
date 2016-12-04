package com.ufo.controller;

import com.alibaba.fastjson.JSON;
import com.ufo.entity.EasyuiGridTemplate;
import com.ufo.init.W2uiGridTemplateLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by frinder6 on 2016/9/26.
 */
@Controller
public class RedirectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedirectController.class);

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/{path}")
    public String redirect(ModelMap modelMap, @PathVariable("path") String path) {
        String gridName = request.getParameter("gridName");
        if (!StringUtils.isEmpty(gridName)) {
            Map<String, Object> gridInfo = new HashMap() {{
                EasyuiGridTemplate gridTemplate = W2uiGridTemplateLoader.GRIDS.get(gridName.toLowerCase());
                put("gridName", gridName);
                put("addUrl", gridTemplate.getAddUrl());
                put("removeUrl", gridTemplate.getAddUrl());
                put("modifyUrl", gridTemplate.getAddUrl());
            }};
            modelMap.put("gridInfo", JSON.toJSONString(gridInfo));
        }
        LOGGER.info("redirect to : " + path);
        LOGGER.info(JSON.toJSONString(modelMap));
        return path;
    }

}
