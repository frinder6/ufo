package com.ufo.entity;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder6 on 2016/11/18.
 */
public class W2uiRequestFactory {

    /**
     * 获取请求查询对象
     *
     * @param request
     * @return
     */
    public static W2uiSearchRequest getSearchRequest(HttpServletRequest request) {
        String requestStr = request.getParameter("request");
        W2uiSearchRequest searchRequest;
        if (StringUtils.isEmpty(requestStr)) {
            searchRequest = new W2uiSearchRequest();
        } else {
            searchRequest = JSON.toJavaObject(JSON.parseObject(requestStr), W2uiSearchRequest.class);
        }
        return searchRequest;
    }


    /**
     * 获取请求新增对象
     *
     * @param request
     * @return
     */
    public static W2uiAddRequest getAddRequest(HttpServletRequest request) {
        String requestStr = request.getParameter("request");
        W2uiAddRequest addRequest;
        if (StringUtils.isEmpty(requestStr)) {
            addRequest = new W2uiAddRequest();
        } else {
            addRequest = JSON.toJavaObject(JSON.parseObject(requestStr), W2uiAddRequest.class);
        }
        return addRequest;
    }

}
