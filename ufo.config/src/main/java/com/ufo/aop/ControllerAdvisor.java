package com.ufo.aop;

import com.alibaba.fastjson.JSON;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder6 on 2016/11/7.
 */
//@ControllerAdvice
public class ControllerAdvisor {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder, NativeWebRequest request) {
        HttpServletRequest servletRequest = (HttpServletRequest) request.getNativeRequest(ServletRequest.class);
        System.out.println(JSON.toJSONString(servletRequest.getParameterNames()));
    }

    @ModelAttribute
    public void addAttributes(Model model, NativeWebRequest request) {
        model.addAttribute("title", "title");
        model.addAttribute("status", 0);
    }


}
