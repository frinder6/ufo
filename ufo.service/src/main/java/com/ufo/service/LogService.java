package com.ufo.service;

import org.aspectj.lang.ProceedingJoinPoint;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder6 on 2016/11/7.
 */
public interface LogService {
    Object insert(ProceedingJoinPoint point, HttpServletRequest request);
}
