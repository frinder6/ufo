package com.ufo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.CaseFormat;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frinder6 on 2016/11/20.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EasyuiGridTemplate {

    /**
     * 额外属性
     */
    private String gridName;
    private String addUrl;
    private String removeUrl;
    private String modifyUrl;
    private String dataOptions;
    /**
     * grid属性
     */
    private String url;
    private List<List<Column>> columns = new ArrayList<>();
    private List<List<Column>> frozenColumns = new ArrayList<>();
    private boolean fitColumns = true;
    private boolean fit = true;
    private boolean autoRowHeight = false;
    private List<Toolbar> toolbar = new ArrayList<>();
    private String method = "post";
    private boolean stripe = true;
    private boolean nowrap = true;
    private String idField = "id";
    private String loadMsg = "加载中，请稍候...";
    private String emptyMsg = "没有符合条件的数据...";
    private boolean pagination = true;
    private boolean rownumbers = false;
    private boolean singleSelect = false;
    private boolean ctrlSelect = false;
    private boolean checkOnSelect = true;
    private boolean selectOnCheck = true;
    private String pagePosition = "bottom";
    private int pageNumber = 1;
    private int pageSize = 50;
    private List<Integer> pageList = new ArrayList() {{
        add(10);
        add(50);
        add(100);
    }};
    private boolean multiSort = false;
    private boolean remoteSort = true;
    private boolean showHeader = true;
    private boolean showFooter = true;
    private int scrollbarSize = 18;
    private int rownumberWidth = 30;
    private int editorHeight = 24;
    private String rowStyler;


    @Data
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Toolbar {
        private String text;
        private String iconCls;
        private boolean plain;
        private boolean disabled;
        private String size;
        private String iconAlign;
        private int width;
        private int height;
        private String handler;
    }


    @Data
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Column {
        private String title;
        private String field;
        private int width;
        private int rowspan;
        private int colspan;
        private String align;
        private String halign;
        private boolean sortable;
        private String order;
        private boolean resizable;
        private boolean fixed;
        private boolean hidden;
        private boolean checkbox;
        private String formatter;
        private String styler;
        private String sorter;
        private String editor;

        public String getField() {
            if (!StringUtils.isEmpty(field) && field.indexOf("_") > -1) {
                field = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, field);
            }
            return field;
        }
    }


    public static void main(String[] args) {
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "abc_de"));
    }

}
