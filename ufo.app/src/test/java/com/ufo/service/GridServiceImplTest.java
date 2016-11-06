package com.ufo.service;

import com.alibaba.fastjson.JSON;
import com.ufo.entity.DxDataEntity;
import com.ufo.service.GridService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by frinder6 on 2016/11/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GridServiceImplTest {

    @Autowired
    private GridService gridService;

    @Autowired
    private MenuService menuService;

    @Test
    public void selectGrid() throws Exception {
        System.out.println(JSON.toJSONString(gridService.selectGrid("导航信息表")));
        DxDataEntity entity = new DxDataEntity();
        entity.setPos(0);
        entity.setSize(10);
        entity.setGridId(1L);
        menuService.selectPage(entity, null);
        System.out.println(JSON.toJSONString(entity));
    }

}