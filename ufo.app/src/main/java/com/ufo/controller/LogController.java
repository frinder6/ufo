package com.ufo.controller;

import com.ufo.entity.EasyuiGridResult;
import com.ufo.entity.LogInfoEntity;
import com.ufo.entity.Page;
import com.ufo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder6 on 2016/12/8.
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    private LogService logService;

    @RequestMapping("/page.logs")
    public EasyuiGridResult page(LogInfoEntity entity) {
        Page page = Page.getInstance(request);
        return logService.selectPage(page, entity);
    }

}
