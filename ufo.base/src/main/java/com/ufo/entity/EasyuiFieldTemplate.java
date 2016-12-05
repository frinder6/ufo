package com.ufo.entity;

import com.google.common.base.CaseFormat;
import lombok.Data;
import org.springframework.util.StringUtils;


@Data
public class EasyuiFieldTemplate {

    private Div div = new Div();
    private Element element = new Element();
    private boolean searchable = true;
    private boolean insertable = true;
    private boolean modifyable = true;


    @Data
    public static class Element {
        private String elementName = "input";
        private String className = "easyui-textbox";
        private String name;
        private String style = "width:100%";
        private DataOptions dataOptions = new DataOptions();

        @Data
        public static class DataOptions {
            private String label;
            private boolean required = false;
            private String url;
            private String validType;
            private boolean multiline = false;
        }
    }

    @Data
    public static class Div {
        private String style = "margin-bottom:20px";
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("<div")
                .append(" style=\"").append(div.getStyle()).append("\">")
                .append("<").append(element.getElementName())
                .append(" class=\"").append(element.getClassName()).append("\"")
                .append(" name=\"").append(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, element.getName())).append("\"")
                .append(" style=\"").append(element.getStyle()).append("\"")
                .append(" data-options=\"")
                .append("label:'").append(element.getDataOptions().getLabel()).append("',")
                .append("required:").append(element.getDataOptions().isRequired()).append(",")
                .append("validType:'").append(element.getDataOptions().getValidType()).append("'");
        if (!StringUtils.isEmpty(element.getDataOptions().getUrl())) {
            result.append(",url:").append(element.getDataOptions().getUrl());
        }
        result.append("\">")
                .append("</div>");
        return result.toString();
    }

}
