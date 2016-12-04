package com.ufo.init;

import com.alibaba.fastjson.JSON;
import com.ufo.entity.EasyuiFormTemplate;
import com.ufo.entity.EasyuiGridTemplate;
import com.ufo.service.impl.GridServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by frinder6 on 2016/11/20.
 */
@Component
public class W2uiGridTemplateLoader {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final Map<String, EasyuiGridTemplate> GRIDS = new ConcurrentHashMap<>();
    public static final Map<String, EasyuiFormTemplate> FROMS = new ConcurrentHashMap<>();
    public static final Map<String, EasyuiFormTemplate> FROMS2 = new ConcurrentHashMap<>();

    @Autowired
    private GridServiceImpl gridService;

    @PostConstruct
    public void load() throws Exception {
        gridService.loadValidGridList(GRIDS);
        gridService.loadValidFormList(FROMS);
        gridService.loadValidFormList2(FROMS2);
        logger.info(JSON.toJSONString(GRIDS));
        logger.info(JSON.toJSONString(FROMS));
        logger.info(JSON.toJSONString(FROMS2));
    }

}
