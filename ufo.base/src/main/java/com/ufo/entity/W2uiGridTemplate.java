package com.ufo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frinder6 on 2016/11/20.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class W2uiGridTemplate {

    private String name;
    private Button buttons;
    private List<Column> columns = new ArrayList<>();
    private String header;
    private int limit = 100;
    private boolean multiSearch = true;
    private boolean multiSelect = true;
    private String recid = "id";
    private int recordHeight = 30;
    private Url url = new Url();
    private Show show = new Show();

    @Data
    public static class Show {
        private boolean header = true;
        private boolean toolbar = true;
        private boolean footer = true;
        private boolean columnHeaders = true;
        private boolean lineNumbers = false;
        private boolean expandColumn = false;
        private boolean selectColumn = true;
        private boolean emptyRecords = true;
        private boolean toolbarReload = true;
        private boolean toolbarColumns = false;
        private boolean toolbarSearch = true;
        private boolean toolbarAdd = true;
        private boolean toolbarDelete = true;
        private boolean toolbarSave = true;
        private boolean selectionBorder = true;
        private boolean recordTitles = true;
        private boolean skipRecords = true;
    }


    @Data
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Button {
        private String id;
        private String type;
        private String img;
        private String hint;
        private boolean arrow;
        private String caption;
        private String html;
        private boolean disabled;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Column {
        private String caption;
        private String field;
        private String size;
        private boolean hidden = false;
        private boolean sortable = true;
        private boolean searchable = true;
        private boolean resizeable = true;
        private String attr;
        private String style;
        private String render;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public static class Editable {
            private String type;
            private List<W2uiComboTemplate> items;
            private boolean showAll;
        }

    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Url {
        private String get;
        private String remove;
        private String save;
    }

}
