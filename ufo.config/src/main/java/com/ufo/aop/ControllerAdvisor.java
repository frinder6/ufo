package com.ufo.aop;

import com.ufo.entity.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder6 on 2016/11/7.
 */
//@ControllerAdvice
public class ControllerAdvisor {

    @ModelAttribute
    public void addAttributes(Model model, NativeWebRequest request) {
        HttpServletRequest servletRequest = (HttpServletRequest) request.getNativeRequest(ServletRequest.class);
        Page page = Page.getInstance(servletRequest);
        model.addAttribute("page", page);
    }


}
