package com.ufo.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.ufo.entity.EasyuiGridResult;
import com.ufo.entity.LogInfoEntity;
import com.ufo.entity.LogInfoEntityWithBLOBs;
import com.ufo.entity.Page;
import com.ufo.mapper.LogInfoEntityMapper;
import com.ufo.mapper.impl.LogInfoEntityMapperImpl;
import com.ufo.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

/**
 * Created by frinder6 on 2016/11/7.
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogInfoEntityMapper logInfoEntityMapper;

    @Autowired
    private LogInfoEntityMapperImpl logInfoEntityMapperImpl;


    /**
     * 分页查询
     *
     * @param page
     * @param entity
     * @return
     */
    @Override
    public EasyuiGridResult selectPage(Page page, LogInfoEntity entity) {
        EasyuiGridResult result = new EasyuiGridResult();
        int count = logInfoEntityMapperImpl.selectPageCount(entity);
        List<LogInfoEntityWithBLOBs> list = logInfoEntityMapperImpl.selectPage(page, entity);
        result.setTotal(count);
        result.setRows(list);
        return result;
    }

    /**
     * 查询符合条件记录数
     *
     * @param entity
     * @return
     */
    @Override
    public int selectPageCount(LogInfoEntity entity) {
        return logInfoEntityMapperImpl.selectPageCount(entity);
    }

    /**
     * 系统记录日志方法
     *
     * @param point
     * @param request
     * @return
     */
    @Override
    public Object insert(ProceedingJoinPoint point, HttpServletRequest request) {
        LogInfoEntityWithBLOBs entity = new LogInfoEntityWithBLOBs();
        entity.setRequestUrl(request.getRequestURL().toString());
        try {
            entity.setRequestParams(URLDecoder.decode(request.getQueryString(), "UTF-8"));
        } catch (Exception e) {
            entity.setRequestParams(request.getQueryString());
        }
        entity.setHost(request.getRemoteAddr());
        entity.setHandler("sys");
        entity.setClassName(point.getTarget().getClass().getName());
        entity.setMethod(point.getSignature().getName());
        try {
            entity.setMethodParams(Joiner.on(",").join(point.getArgs()));
        } catch (Exception e) {
            entity.setMethodParams("{}");
        }
        entity.setCreateTime(new Date());
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            entity.setStatus(false);
            entity.setError(throwable.getMessage());
        }
        try {
            entity.setResult(JSON.toJSONString(result));
        } catch (Exception e) {
            entity.setResult(String.valueOf(result));
        }
        try {
            logInfoEntityMapper.insertSelective(entity);
        } catch (Exception e) {
        }
        return result;
    }

}
