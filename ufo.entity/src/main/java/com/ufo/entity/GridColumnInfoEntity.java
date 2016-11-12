package com.ufo.entity;

import java.util.Date;

public class GridColumnInfoEntity {
    private Long id;

    private Long gridId;

    private Long dataId;

    private String title;

    private String name;

    private String type;

    private String value;

    private String validate;

    private Byte required;

    private Byte isSearch;

    private Byte isInsert;

    private Byte isModify;

    private Byte status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate == null ? null : validate.trim();
    }

    public Byte getRequired() {
        return required;
    }

    public void setRequired(Byte required) {
        this.required = required;
    }

    public Byte getIsSearch() {
        return isSearch;
    }

    public void setIsSearch(Byte isSearch) {
        this.isSearch = isSearch;
    }

    public Byte getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(Byte isInsert) {
        this.isInsert = isInsert;
    }

    public Byte getIsModify() {
        return isModify;
    }

    public void setIsModify(Byte isModify) {
        this.isModify = isModify;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
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
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getValidate() == null ? other.getValidate() == null : this.getValidate().equals(other.getValidate()))
            && (this.getRequired() == null ? other.getRequired() == null : this.getRequired().equals(other.getRequired()))
            && (this.getIsSearch() == null ? other.getIsSearch() == null : this.getIsSearch().equals(other.getIsSearch()))
            && (this.getIsInsert() == null ? other.getIsInsert() == null : this.getIsInsert().equals(other.getIsInsert()))
            && (this.getIsModify() == null ? other.getIsModify() == null : this.getIsModify().equals(other.getIsModify()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getValidate() == null) ? 0 : getValidate().hashCode());
        result = prime * result + ((getRequired() == null) ? 0 : getRequired().hashCode());
        result = prime * result + ((getIsSearch() == null) ? 0 : getIsSearch().hashCode());
        result = prime * result + ((getIsInsert() == null) ? 0 : getIsInsert().hashCode());
        result = prime * result + ((getIsModify() == null) ? 0 : getIsModify().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", value=").append(value);
        sb.append(", validate=").append(validate);
        sb.append(", required=").append(required);
        sb.append(", isSearch=").append(isSearch);
        sb.append(", isInsert=").append(isInsert);
        sb.append(", isModify=").append(isModify);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", creater=").append(creater);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updater=").append(updater);
        sb.append("]");
        return sb.toString();
    }
}