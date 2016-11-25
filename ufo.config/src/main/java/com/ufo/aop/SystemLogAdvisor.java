package com.ufo.aop;

import com.alibaba.fastjson.JSON;
import com.ufo.entity.LogInfoEntity;
import com.ufo.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created on 2016/7/31.
 */
@Component
@Aspect
public class SystemLogAdvisor {

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAdvisor.class);

    @Pointcut("execution(* com.ufo..*(..))")
    public void logPointCut() {
    }

    @Pointcut("execution(* com.ufo.controller..*(..))")
    public void controllerPointCut() {
    }

    //    @Before("logPointCut()")
    public void preHandle() {
        logger.debug("***********************************");
        logger.debug("************* start ***************");
        logger.debug("***********************************");
        logger.info("prepare execute data !");
    }


    //    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void postHandle(Object result) {
        try {
            logger.info("it returns : " + JSON.toJSONString(result));
        } catch (Exception e) {
            logger.info("it returns : " + result.toString());
        }
        logger.debug("***********************************");
        logger.debug("************* finish **************");
        logger.debug("***********************************");
    }


    //    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public void throwHandle(Exception e) {
        logger.error("execute error : " + e.getMessage());
        logger.debug("***********************************");
        logger.debug("*********** throwable *************");
        logger.debug("***********************************");
    }

    @Around("logPointCut()")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        long bTime = System.currentTimeMillis();
        try {
            logger.info("request info : " + JSON.toJSONString(point));
        } catch (Exception e) {
            logger.info("request info : " + point.toLongString());
        }
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            logger.error("execute error : " + throwable.getMessage(), throwable);
            // throw new Throwable(throwable);
        }
        try {
            logger.info("response info : " + JSON.toJSONString(result));
        } catch (Exception e) {
            logger.info(result.toString());
        }
        long eTime = System.currentTimeMillis();
        logger.info("take time : " + (eTime - bTime) + " ms !");
        return result;
    }

    @Autowired
    private LogService logService;

    @Around("controllerPointCut()")
    public Object controllerHandle(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Object result = logService.insert(point, request);
        return result;
    }


}
