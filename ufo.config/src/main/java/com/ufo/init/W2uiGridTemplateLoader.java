package com.ufo.init;

import com.alibaba.fastjson.JSON;
import com.ufo.entity.W2uiGridTemplate;
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

    public static final Map<String, W2uiGridTemplate> GRIDS = new ConcurrentHashMap<>();

    @Autowired
    private GridServiceImpl gridService;

    @PostConstruct
    public void load() throws Exception {
        gridService.loadValidGridList(GRIDS);
        logger.info(JSON.toJSONString(GRIDS));
    }

}
