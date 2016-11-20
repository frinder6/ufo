package com.ufo.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Set;

/**
 * Created by frinder6 on 2016/11/18.
 */
@Data
public class W2uiAddRequest {

    private String cmd;
    private long recid;
    // private String name;
    private JSONObject record;


    /**
     * 转换新境对象
     *
     * @param target
     * @param <T>
     * @return
     */
    public <T> T convert2Object(Class<T> target) {
        JSONObject jsonObject = this.getRecord();
        Set<String> keys = jsonObject.keySet();
        Object v;
        for (String key : keys) {
            v = jsonObject.get(key);
            if (v instanceof JSONObject) {
                JSONObject vObject = jsonObject.getJSONObject(key);
                jsonObject.put(key, vObject.get("id"));
            }
        }
        return JSON.toJavaObject(jsonObject, target);
    }


}
