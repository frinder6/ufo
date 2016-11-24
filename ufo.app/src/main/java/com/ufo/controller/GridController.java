package com.ufo.controller;

import com.alibaba.fastjson.JSON;
import com.ufo.entity.EasyuiFormTemplate;
import com.ufo.entity.EasyuiGridTemplate;
import com.ufo.entity.EasyuiResponse;
import com.ufo.init.W2uiGridTemplateLoader;
import com.ufo.service.GridService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by frinder6 on 2016/11/5.
 */
@RestController
@RequestMapping("/grid")
public class GridController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GridService gridService;

    @RequestMapping("/grid.options")
    public EasyuiGridTemplate gridTemplate(@RequestParam("gridName") String gridName) {
        return W2uiGridTemplateLoader.GRIDS.get(gridName);
    }

    @RequestMapping("/grid.form")
    public StringBuilder formTemplate(@RequestParam("gridName") String gridName, @RequestParam("action") String action) {
        EasyuiFormTemplate template = W2uiGridTemplateLoader.FROMS.get(gridName.toLowerCase());
        if ("search".equalsIgnoreCase(action)) {
            return template.getSearch();
        } else if ("insert".equalsIgnoreCase(action)) {
            return template.getInsert();
        } else if ("modify".equalsIgnoreCase(action)) {
            return template.getModify();
        }
        return null;
    }


    @RequestMapping("/flush")
    public EasyuiResponse flush() throws Exception {
        W2uiGridTemplateLoader.GRIDS.clear();
        W2uiGridTemplateLoader.FROMS.clear();
        logger.info(JSON.toJSONString(W2uiGridTemplateLoader.GRIDS));
        logger.info(JSON.toJSONString(W2uiGridTemplateLoader.FROMS));
        gridService.loadValidGridList(W2uiGridTemplateLoader.GRIDS);
        gridService.loadValidFormList(W2uiGridTemplateLoader.FROMS);
        logger.info(JSON.toJSONString(W2uiGridTemplateLoader.GRIDS));
        logger.info(JSON.toJSONString(W2uiGridTemplateLoader.FROMS));
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "刷新成功！");
    }


}
