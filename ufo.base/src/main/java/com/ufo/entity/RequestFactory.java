package com.ufo.entity;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder6 on 2016/11/18.
 */
public class RequestFactory {

    /**
     * 获取请求查询对象
     *
     * @param request
     * @return
     */
    public static M2uiSearchRequest getSearchRequest(HttpServletRequest request) {
        String requestStr = request.getParameter("request");
        M2uiSearchRequest searchRequest;
        if (StringUtils.isEmpty(requestStr)) {
            searchRequest = new M2uiSearchRequest();
        } else {
            searchRequest = JSON.toJavaObject(JSON.parseObject(requestStr), M2uiSearchRequest.class);
        }
        return searchRequest;
    }


    /**
     * 获取请求新增对象
     *
     * @param request
     * @return
     */
    public static M2uiAddRequest getAddRequest(HttpServletRequest request) {
        String requestStr = request.getParameter("request");
        M2uiAddRequest addRequest;
        if (StringUtils.isEmpty(requestStr)) {
            addRequest = new M2uiAddRequest();
        } else {
            addRequest = JSON.toJavaObject(JSON.parseObject(requestStr), M2uiAddRequest.class);
        }
        return addRequest;
    }

}
