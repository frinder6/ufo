package com.ufo.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder6 on 2016/9/27.
 */
@RestController
@RequestMapping("/bean")
public class BeanController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping("/print")
    public List<Map<String, String>> print() {
        List<Map<String, String>> result = new ArrayList() {{
            String[] beans = applicationContext.getBeanDefinitionNames();
            Map<String, String> map;
            for (String bean : beans) {
                map = new HashMap() {{
                    put("text", bean);
                }};
                add(map);
            }
        }};
        return result;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
