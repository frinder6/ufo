package com.ufo.controller;

import com.ufo.entity.QueueLog;
import com.ufo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 2016/7/30.
 */
@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private IService<QueueLog> queueLogService;


    @Transactional
    @RequestMapping("/1")
    public ModelAndView hello() {
        QueueLog log = new QueueLog();
        log.setIp("xxxx");
        log.setQueueName("xxxxx");
        log.setExchangeName("xxxxxx");
        log.setRoutingKey("xxxxxx");
        log.setClassName("xxxxxxx");
        log.setContext("xxxxxx");
        this.queueLogService.insert(log);
        return new ModelAndView();
    }

}
