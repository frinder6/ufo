package com.ufo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by frinder6 on 2016/9/26.
 */
@Controller
public class RedirectController {

    @RequestMapping("/")
    public String redirect(){
        System.out.println("............................");
        return "index";
    }

}
