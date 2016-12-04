package com.ufo.entity;

import lombok.Data;


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

}
