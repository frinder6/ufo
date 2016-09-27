package com.ufo.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2016/7/30.
 */
@Component
public class ExecuteTimeInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String B_IMTE = "B_TIME";


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        long bTime = System.currentTimeMillis();
        logger.info("before " + httpServletRequest.getRequestURI() + " execute : " + bTime);
        httpServletRequest.setAttribute(B_IMTE, bTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info(httpServletRequest.getRequestURI() + " executed : " + System.currentTimeMillis());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        long tmpTime = (long) httpServletRequest.getAttribute(B_IMTE);
        long eTime = System.currentTimeMillis();
        logger.info("after " + httpServletRequest.getRequestURI() + " execute : " + eTime);
        logger.info("all " + httpServletRequest.getRequestURI() + " handle time : " + (eTime - tmpTime) + " ms !");
    }
}
