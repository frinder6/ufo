package com.ufo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by frinder6 on 2016/9/26.
 */
@Controller
public class RedirectController {

    @RequestMapping("/{path}")
    public String redirect(@PathVariable("path") String path) {
        return path;
    }

}
