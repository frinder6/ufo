package com.ufo.dao;

import com.alibaba.fastjson.JSON;
import com.ufo.mapper.impl.MenuInfoEntityMapperImpl;
import com.ufo.service.GridService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by frinder6 on 2016/9/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MenuInfoEntityDaoTest {

    @Autowired
    private MenuInfoEntityMapperImpl menuInfoEntityMapperImpl;

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(menuInfoEntityMapperImpl.selectByPid(0L)));
    }

}