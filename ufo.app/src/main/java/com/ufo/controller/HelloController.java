package com.ufo.controller;

import com.alibaba.fastjson.JSON;
import com.ufo.entity.QueueInfoEntity;
import com.ufo.entity.QueueLogEntity;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;
import com.ufo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2016/7/30.
 */
@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private IService<QueueLogEntity> queueLogService;

    @Autowired
    private IService<QueueInfoEntity> queueInfoService;


    @Transactional
    @RequestMapping("/1")
    public ModelAndView hello() throws SqlFormatException {
        QueueInfoEntity entity = new QueueInfoEntity();
//        entity.setStatus((byte) 1);
//        String[] whereCols = {"status"};
//        List<QueueInfoEntity> list = this.queueInfoService.selectForList(entity, whereCols);
//        System.out.println(JSON.toJSONString(list));
        entity.setId(1L);
        String[] whereCols = {"id"};
        SqlEntity<QueueInfoEntity> sqlEntity = new SqlEntity<>();
        sqlEntity.setEntity(entity);
        sqlEntity.setWhereCols(Arrays.asList(whereCols));
        entity = this.queueInfoService.selectForSingle(sqlEntity);
        System.out.println(JSON.toJSONString(entity));
        return new ModelAndView();
    }

}
