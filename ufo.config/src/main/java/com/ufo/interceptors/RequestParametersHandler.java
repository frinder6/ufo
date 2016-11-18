package com.ufo.interceptors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Created by frinder6 on 2016/11/17.
 */
public class RequestParametersHandler {

    /**
     * 重置 request 请求数据
     *
     * @param request
     */
    public static void resetRequest(HttpServletRequest request) {
        String requestStr = request.getParameter("request");
        if (!StringUtils.isEmpty(requestStr)) {
            JSONObject requestJson = JSON.parseObject(requestStr);
            if (requestJson.containsKey("cmd")) {
                String cmd = requestJson.getString("cmd");
                if ("get".equalsIgnoreCase(cmd)) {
                    if (requestJson.containsKey("search")) {
                        JSONArray searchArray = requestJson.getJSONArray("search");
                        for (Object searchStr : searchArray) {
                            JSONObject searchObject = JSON.parseObject(searchStr.toString());
                            if (searchObject.containsKey("type")) {
                                String type = searchObject.getString("type");
                                if ("text".equalsIgnoreCase(type) || ("list".equalsIgnoreCase(type) && searchObject.containsKey("text"))) {
                                    request.setAttribute(searchObject.getString("field"), searchObject.get("value"));
                                }
                            }
                        }
                    }
                } else if ("save".equalsIgnoreCase(cmd)) {
                    if (requestJson.containsKey("record")) {
                        JSONObject recordJson = JSON.parseObject(requestJson.getString("record"));
                        Set<String> keys = recordJson.keySet();
                        for (String k : keys) {
                            String v = recordJson.getString(k);
                            if (v.indexOf("id") > -1 && v.indexOf("{") > -1 && v.indexOf("{") > -1) {
                                JSONObject sJson = JSON.parseObject(v);
                                request.setAttribute(k, sJson.get("id"));
                            } else {
                                request.setAttribute(k, v);
                            }
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        String json = "{\"cmd\":\"get\",\"selected\":[],\"limit\":100,\"offset\":0,\"search\":[{\"field\":\"title\",\"type\":\"text\",\"operator\":\"begins\",\"value\":\"aa\"}],\"searchLogic\":\"AND\"}";
        JSONObject jsonObject = JSON.parseObject(json);
        Set<String> keys = jsonObject.keySet();
        for (String k : keys) {
            System.out.println(k + " = " + jsonObject.get(k));
        }
    }

}
