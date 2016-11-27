package com.ufo.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
        modelMap.addAttribute("gridName", request.getParameter("gridName"));
        LOGGER.info("redirect to : " + path);
        LOGGER.info(JSON.toJSONString(modelMap));
        return path;
    }

}
