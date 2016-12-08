package com.ufo.service;

import com.ufo.entity.EasyuiGridResult;
import com.ufo.entity.LogInfoEntity;
import com.ufo.entity.Page;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder6 on 2016/11/7.
 */
public interface LogService {

    Object insert(ProceedingJoinPoint point, HttpServletRequest request);

    EasyuiGridResult selectPage(Page page, LogInfoEntity entity);

    int selectPageCount(LogInfoEntity entity);
}
