package com.ufo.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/18.
 */
@Data
public class W2uiSearchRequest {

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
        String field;
        if (!CollectionUtils.isEmpty(searchs)) {
            for (Search s : searchs) {
                field = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, s.getField());
                jsonObject.put(field, s.getValue());
            }
        }
        List<Sort> sorts = this.getSort();
        if (!CollectionUtils.isEmpty(sorts)) {
            for (Sort s : sorts) {
                field = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, s.getField());
                jsonObject.put("field", field);
                jsonObject.put("direction", s.getDirection());
            }
        }
        return JSON.toJavaObject(jsonObject, target);
    }

    public static void main(String[] args) {
        String str = "updateTime";
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str));
    }


}
