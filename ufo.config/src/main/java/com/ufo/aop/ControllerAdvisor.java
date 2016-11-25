package com.ufo.aop;

import com.ufo.entity.EasyuiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by frinder6 on 2016/11/7.
 */
@ControllerAdvice
public class ControllerAdvisor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public EasyuiResponse exception(Exception e) {
        LOGGER.error(e.getMessage(), e);
        EasyuiResponse response = new EasyuiResponse(EasyuiResponse.ERROR);
        response.setMessage("系统去开ufo了，请稍后重试！");
        return response;
    }


}
