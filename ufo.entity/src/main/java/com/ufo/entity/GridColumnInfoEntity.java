package com.ufo.entity;

import java.util.Date;

public class GridColumnInfoEntity {
    private Long id;

    private Long gridId;

    private Long dataId;

    private String title;

    private String field;

    private String dataOptions;

    private Integer width;

    private Integer rowspan;

    private Integer colspan;

    private String halign;

    private String align;

    private Boolean sortable;

    private String order;

    private Boolean resizable;

    private Boolean fixed;

    private Boolean hidden;

    private Boolean checkbox;

    private Boolean frozen;

    private String formatter;

    private String styler;

    private String sorter;

    private String editor;

    private String type;

    private String value;

    private String validType;

    private Boolean required;

    private Boolean searchable;

    private Boolean insertable;

    private Boolean modifyable;

    private Boolean status;

    private Date createTime;

    private String creater;

    private Date updateTime;

    private String updater;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGridId() {
        return gridId;
    }

    public void setGridId(Long gridId) {
        this.gridId = gridId;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public String getDataOptions() {
        return dataOptions;
    }

    public void setDataOptions(String dataOptions) {
        this.dataOptions = dataOptions == null ? null : dataOptions.trim();
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getRowspan() {
        return rowspan;
    }

    public void setRowspan(Integer rowspan) {
        this.rowspan = rowspan;
    }

    public Integer getColspan() {
        return colspan;
    }

    public void setColspan(Integer colspan) {
        this.colspan = colspan;
    }

    public String getHalign() {
        return halign;
    }

    public void setHalign(String halign) {
        this.halign = halign == null ? null : halign.trim();
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align == null ? null : align.trim();
    }

    public Boolean getSortable() {
        return sortable;
    }

    public void setSortable(Boolean sortable) {
        this.sortable = sortable;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order == null ? null : order.trim();
    }

    public Boolean getResizable() {
        return resizable;
    }

    public void setResizable(Boolean resizable) {
        this.resizable = resizable;
    }

    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Boolean checkbox) {
        this.checkbox = checkbox;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter == null ? null : formatter.trim();
    }

    public String getStyler() {
        return styler;
    }

    public void setStyler(String styler) {
        this.styler = styler == null ? null : styler.trim();
    }

    public String getSorter() {
        return sorter;
    }

    public void setSorter(String sorter) {
        this.sorter = sorter == null ? null : sorter.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getValidType() {
        return validType;
    }

    public void setValidType(String validType) {
        this.validType = validType == null ? null : validType.trim();
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public Boolean getInsertable() {
        return insertable;
    }

    public void setInsertable(Boolean insertable) {
        this.insertable = insertable;
    }

    public Boolean getModifyable() {
        return modifyable;
    }

    public void setModifyable(Boolean modifyable) {
        this.modifyable = modifyable;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GridColumnInfoEntity other = (GridColumnInfoEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGridId() == null ? other.getGridId() == null : this.getGridId().equals(other.getGridId()))
            && (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getField() == null ? other.getField() == null : this.getField().equals(other.getField()))
            && (this.getDataOptions() == null ? other.getDataOptions() == null : this.getDataOptions().equals(other.getDataOptions()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getRowspan() == null ? other.getRowspan() == null : this.getRowspan().equals(other.getRowspan()))
            && (this.getColspan() == null ? other.getColspan() == null : this.getColspan().equals(other.getColspan()))
            && (this.getHalign() == null ? other.getHalign() == null : this.getHalign().equals(other.getHalign()))
            && (this.getAlign() == null ? other.getAlign() == null : this.getAlign().equals(other.getAlign()))
            && (this.getSortable() == null ? other.getSortable() == null : this.getSortable().equals(other.getSortable()))
            && (this.getOrder() == null ? other.getOrder() == null : this.getOrder().equals(other.getOrder()))
            && (this.getResizable() == null ? other.getResizable() == null : this.getResizable().equals(other.getResizable()))
            && (this.getFixed() == null ? other.getFixed() == null : this.getFixed().equals(other.getFixed()))
            && (this.getHidden() == null ? other.getHidden() == null : this.getHidden().equals(other.getHidden()))
            && (this.getCheckbox() == null ? other.getCheckbox() == null : this.getCheckbox().equals(other.getCheckbox()))
            && (this.getFrozen() == null ? other.getFrozen() == null : this.getFrozen().equals(other.getFrozen()))
            && (this.getFormatter() == null ? other.getFormatter() == null : this.getFormatter().equals(other.getFormatter()))
            && (this.getStyler() == null ? other.getStyler() == null : this.getStyler().equals(other.getStyler()))
            && (this.getSorter() == null ? other.getSorter() == null : this.getSorter().equals(other.getSorter()))
            && (this.getEditor() == null ? other.getEditor() == null : this.getEditor().equals(other.getEditor()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getValidType() == null ? other.getValidType() == null : this.getValidType().equals(other.getValidType()))
            && (this.getRequired() == null ? other.getRequired() == null : this.getRequired().equals(other.getRequired()))
            && (this.getSearchable() == null ? other.getSearchable() == null : this.getSearchable().equals(other.getSearchable()))
            && (this.getInsertable() == null ? other.getInsertable() == null : this.getInsertable().equals(other.getInsertable()))
            && (this.getModifyable() == null ? other.getModifyable() == null : this.getModifyable().equals(other.getModifyable()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGridId() == null) ? 0 : getGridId().hashCode());
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getField() == null) ? 0 : getField().hashCode());
        result = prime * result + ((getDataOptions() == null) ? 0 : getDataOptions().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getRowspan() == null) ? 0 : getRowspan().hashCode());
        result = prime * result + ((getColspan() == null) ? 0 : getColspan().hashCode());
        result = prime * result + ((getHalign() == null) ? 0 : getHalign().hashCode());
        result = prime * result + ((getAlign() == null) ? 0 : getAlign().hashCode());
        result = prime * result + ((getSortable() == null) ? 0 : getSortable().hashCode());
        result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
        result = prime * result + ((getResizable() == null) ? 0 : getResizable().hashCode());
        result = prime * result + ((getFixed() == null) ? 0 : getFixed().hashCode());
        result = prime * result + ((getHidden() == null) ? 0 : getHidden().hashCode());
        result = prime * result + ((getCheckbox() == null) ? 0 : getCheckbox().hashCode());
        result = prime * result + ((getFrozen() == null) ? 0 : getFrozen().hashCode());
        result = prime * result + ((getFormatter() == null) ? 0 : getFormatter().hashCode());
        result = prime * result + ((getStyler() == null) ? 0 : getStyler().hashCode());
        result = prime * result + ((getSorter() == null) ? 0 : getSorter().hashCode());
        result = prime * result + ((getEditor() == null) ? 0 : getEditor().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getValidType() == null) ? 0 : getValidType().hashCode());
        result = prime * result + ((getRequired() == null) ? 0 : getRequired().hashCode());
        result = prime * result + ((getSearchable() == null) ? 0 : getSearchable().hashCode());
        result = prime * result + ((getInsertable() == null) ? 0 : getInsertable().hashCode());
        result = prime * result + ((getModifyable() == null) ? 0 : getModifyable().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gridId=").append(gridId);
        sb.append(", dataId=").append(dataId);
        sb.append(", title=").append(title);
        sb.append(", field=").append(field);
        sb.append(", dataOptions=").append(dataOptions);
        sb.append(", width=").append(width);
        sb.append(", rowspan=").append(rowspan);
        sb.append(", colspan=").append(colspan);
        sb.append(", halign=").append(halign);
        sb.append(", align=").append(align);
        sb.append(", sortable=").append(sortable);
        sb.append(", order=").append(order);
        sb.append(", resizable=").append(resizable);
        sb.append(", fixed=").append(fixed);
        sb.append(", hidden=").append(hidden);
        sb.append(", checkbox=").append(checkbox);
        sb.append(", frozen=").append(frozen);
        sb.append(", formatter=").append(formatter);
        sb.append(", styler=").append(styler);
        sb.append(", sorter=").append(sorter);
        sb.append(", editor=").append(editor);
        sb.append(", type=").append(type);
        sb.append(", value=").append(value);
        sb.append(", validType=").append(validType);
        sb.append(", required=").append(required);
        sb.append(", searchable=").append(searchable);
        sb.append(", insertable=").append(insertable);
        sb.append(", modifyable=").append(modifyable);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", creater=").append(creater);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updater=").append(updater);
        sb.append("]");
        return sb.toString();
    }
}