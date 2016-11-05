package com.ufo.controller;

import com.ufo.entity.DxGridTemplate;
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

    @RequestMapping("/dx.grid.options")
    public DxGridTemplate dxGridTemplate(@RequestParam("gridName") String gridName) {
        return gridService.selectGrid(gridName);
    }

}
