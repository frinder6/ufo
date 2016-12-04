package com.ufo.controller;

import com.alibaba.fastjson.JSON;
import com.ufo.entity.*;
import com.ufo.init.W2uiGridTemplateLoader;
import com.ufo.service.GridService;
import com.ufo.vo.ColumnsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by frinder6 on 2016/11/5.
 */
@RestController
@RequestMapping("/grid")
public class GridController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    private GridService gridService;

    @RequestMapping("/add.grid")
    public EasyuiResponse add(GridInfoEntity entity) {
        gridService.insert(entity);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "新增成功！");
    }

    @RequestMapping("/add.remove")
    public EasyuiResponse remove(Long id) {
        gridService.delete(id);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "删除成功！");
    }

    @RequestMapping("/add.modify")
    public EasyuiResponse modify(GridInfoEntity entity) {
        gridService.update(entity);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "更新成功！");
    }


    @RequestMapping(value = "/add.columns", consumes = "application/json; charset=utf-8")
    public EasyuiResponse addColumns(@RequestBody ColumnsVO columnsVO) {
        gridService.batchInsertSelective(columnsVO);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "配置成功！");
    }


    @RequestMapping("/page.grids")
    public EasyuiGridResult page(GridInfoEntity entity) {
        Page page = Page.getInstance(request);
        return gridService.selectPage(page, entity);
    }


    @RequestMapping("/page.tables")
    public EasyuiGridResult tablePage() {
        Page page = Page.getInstance(request);
        return gridService.selectTablePage(page);
    }


    @RequestMapping("/page.table.columns")
    public EasyuiGridResult tableColumnPage(
            @RequestParam(required = false, name = "tableName") String tableName,
            @RequestParam(required = false, name = "gridId") Long gridId) {
        Page page = Page.getInstance(request);
        if (StringUtils.isEmpty(tableName) || null == gridId) {
            return EasyuiGridResult.getEmptyInstance();
        }
        tableName = StringUtils.isEmpty(tableName) ? "" : tableName;
        gridId = null == gridId ? 0L : gridId;
        return gridService.selectTableColumnPage(page, tableName, gridId);
    }

    @RequestMapping("/page.columns")
    public EasyuiGridResult columnPage(GridColumnInfoEntity entity) {
        Page page = Page.getInstance(request);
        return gridService.selectColumnPage(page, entity);
    }


    @RequestMapping("/grid.options")
    public EasyuiGridTemplate gridTemplate(@RequestParam("gridName") String gridName) {
        return W2uiGridTemplateLoader.GRIDS.get(gridName.toLowerCase());
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
