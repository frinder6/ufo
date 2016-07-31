package com.ufo.controller;

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


    @Transactional
    @RequestMapping("/1")
    public ModelAndView hello() {
        System.out.println("hello world...");
        return new ModelAndView();
    }

}
