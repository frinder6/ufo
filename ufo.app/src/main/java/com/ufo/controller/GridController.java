package com.ufo.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
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
import java.util.Collection;
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

    /**
     * 添加 grid
     *
     * @param entity
     * @return
     */
    @RequestMapping("/add.grid")
    public EasyuiResponse add(GridInfoEntity entity) {
        gridService.insert(entity);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "新增成功！");
    }

    /**
     * 删除 grid
     *
     * @param id
     * @return
     */
    @RequestMapping("/remove.grid")
    public EasyuiResponse remove(Long id) {
        gridService.delete(id);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "删除成功！");
    }

    /**
     * 更新 grid
     *
     * @param entity
     * @return
     */
    @RequestMapping("/update.grid")
    public EasyuiResponse modify(GridInfoEntity entity) {
        gridService.update(entity);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "更新成功！");
    }


    /**
     * 批量新增 grid columns
     *
     * @param columnsVO
     * @return
     */
    @RequestMapping(value = "/add.columns", consumes = "application/json; charset=utf-8")
    public EasyuiResponse addColumns(@RequestBody ColumnsVO columnsVO) {
        gridService.batchInsertSelective(columnsVO);
        return new EasyuiResponse(EasyuiResponse.SUCCESS, "配置成功！");
    }


    /**
     * 分页查询 grid
     *
     * @param entity
     * @return
     */
    @RequestMapping("/page.grids")
    public EasyuiGridResult page(GridInfoEntity entity) {
        Page page = Page.getInstance(request);
        return gridService.selectPage(page, entity);
    }


    /**
     * 分页查询系统表
     *
     * @return
     */
    @RequestMapping("/page.tables")
    public EasyuiGridResult tablePage() {
        Page page = Page.getInstance(request);
        return gridService.selectTablePage(page);
    }


    /**
     * 分页查询系统表列
     *
     * @param tableName
     * @param gridId
     * @return
     */
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

    /**
     * 分页查询 grid columns
     *
     * @param entity
     * @return
     */
    @RequestMapping("/page.columns")
    public EasyuiGridResult columnPage(GridColumnInfoEntity entity) {
        Page page = Page.getInstance(request);
        return gridService.selectColumnPage(page, entity);
    }


    /**
     * 获取 grid 配置信息
     *
     * @param gridName
     * @return
     */
    @RequestMapping("/grid.options")
    public EasyuiGridTemplate gridTemplate(@RequestParam("gridName") String gridName) {
        return W2uiGridTemplateLoader.GRIDS.get(gridName.toLowerCase());
    }

    /**
     * 获取 grid form
     *
     * @param gridName
     * @param action
     * @return
     */
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


    /**
     * 获取 grid extend信息
     *
     * @param gridId
     * @return
     */
    @RequestMapping("/grid.extend")
    public GridExtendInfoEntity gridExtendInfoEntity(@RequestParam("gridId") Long gridId) {
        return gridService.getGridExtendInfoByGridId(gridId);
    }


    /**
     * 刷新 grid 信息
     *
     * @return
     * @throws Exception
     */
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
