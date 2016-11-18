package com.ufo.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/18.
 */
@Data
public class M2uiSearchRequest {

    private String cmd;
    private int limit;
    private int offset;
    private List<Object> selected;
    private String searchLogic;
    private List<Search> search;
    private List<Sort> sort;


    @Data
    public static class Search {
        private String field;
        private String type;
        private String operator;
        private String value;
        private String text;
    }

    @Data
    private static class Sort {
        private String field;
        private String direction;
    }

    /**
     * 转换查询对象
     *
     * @param target
     * @param <T>
     * @return
     */
    public <T> T convert2Object(Class<T> target) {
        JSONObject jsonObject = new JSONObject();
        List<Search> searchs = this.getSearch();
        if (!CollectionUtils.isEmpty(searchs)) {
            for (Search s : searchs) {
                jsonObject.put(s.getField(), s.getValue());
            }
        }
        List<Sort> sorts = this.getSort();
        if (!CollectionUtils.isEmpty(sorts)) {
            for (Sort s : sorts) {
                jsonObject.put(s.getField(), s.getDirection());
            }
        }
        return JSON.toJavaObject(jsonObject, target);
    }


}
