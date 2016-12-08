package com.ufo.service;

import com.ufo.entity.GridColumnInfoEntity;
import com.ufo.vo.ColumnsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by frinder6 on 2016/11/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GridServiceImplTest {

    @Autowired
    private GridService gridService;

    @Test
    public void selectGrid() throws Exception {
//        System.out.println(JSON.toJSONString(gridService.selectGrid("导航信息表")));
        ColumnsVO columnsVO = new ColumnsVO();
        columnsVO.setGridId(9L);
        GridColumnInfoEntity entity1 = new GridColumnInfoEntity();
        entity1.setField("标题");
        entity1.setField("title");
        GridColumnInfoEntity entity2 = new GridColumnInfoEntity();
        entity2.setField("名称");
        entity2.setField("name");
        columnsVO.getEntityList().add(entity1);
        columnsVO.getEntityList().add(entity2);
        gridService.batchInsertSelective(columnsVO);
    }

}