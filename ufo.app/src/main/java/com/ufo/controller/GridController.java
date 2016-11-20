package com.ufo.controller;

import com.ufo.entity.DxGridResult;
import com.ufo.entity.GridInfoEntity;
import com.ufo.entity.W2uiGridTemplate;
import com.ufo.entity.W2uiResponse;
import com.ufo.init.W2uiGridTemplateLoader;
import com.ufo.service.GridService;
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

    @Autowired
    private GridService gridService;

    @RequestMapping("/grid.options")
    public W2uiGridTemplate dxGridTemplate(@RequestParam("gridName") String gridName) {
        return W2uiGridTemplateLoader.GRIDS.get(gridName);
    }

    @RequestMapping("/flush")
    public W2uiResponse flush() throws Exception {
        W2uiGridTemplateLoader.GRIDS.clear();
        gridService.loadValidGridList(W2uiGridTemplateLoader.GRIDS);
        return new W2uiResponse(W2uiResponse.SUCCESS, "刷新成功！");
    }


    @RequestMapping("/table.columns")
    public DxGridResult columns4Table(@RequestParam("tableName") String tableName) {
        DxGridResult result = new DxGridResult();
        result.setData(gridService.selectColumns(tableName));
        return result;
    }

    @RequestMapping("/page.grid")
    public DxGridResult page(GridInfoEntity record) {
        DxGridResult result = new DxGridResult();
        result.setData(gridService.selectPage(record));
        return result;
    }

}
