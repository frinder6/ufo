package com.ufo.entity;

import java.util.Date;

public class GridExtendInfoEntity {
    private Long id;

    private Long gridId;

    private String header;

    private String recid;

    private Integer limit;

    private Integer recordHeight;

    private String toolbar;

    private Integer total;

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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getRecid() {
        return recid;
    }

    public void setRecid(String recid) {
        this.recid = recid == null ? null : recid.trim();
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getRecordHeight() {
        return recordHeight;
    }

    public void setRecordHeight(Integer recordHeight) {
        this.recordHeight = recordHeight;
    }

    public String getToolbar() {
        return toolbar;
    }

    public void setToolbar(String toolbar) {
        this.toolbar = toolbar == null ? null : toolbar.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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
        GridExtendInfoEntity other = (GridExtendInfoEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGridId() == null ? other.getGridId() == null : this.getGridId().equals(other.getGridId()))
            && (this.getHeader() == null ? other.getHeader() == null : this.getHeader().equals(other.getHeader()))
            && (this.getRecid() == null ? other.getRecid() == null : this.getRecid().equals(other.getRecid()))
            && (this.getLimit() == null ? other.getLimit() == null : this.getLimit().equals(other.getLimit()))
            && (this.getRecordHeight() == null ? other.getRecordHeight() == null : this.getRecordHeight().equals(other.getRecordHeight()))
            && (this.getToolbar() == null ? other.getToolbar() == null : this.getToolbar().equals(other.getToolbar()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
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
        result = prime * result + ((getHeader() == null) ? 0 : getHeader().hashCode());
        result = prime * result + ((getRecid() == null) ? 0 : getRecid().hashCode());
        result = prime * result + ((getLimit() == null) ? 0 : getLimit().hashCode());
        result = prime * result + ((getRecordHeight() == null) ? 0 : getRecordHeight().hashCode());
        result = prime * result + ((getToolbar() == null) ? 0 : getToolbar().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
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
        sb.append(", header=").append(header);
        sb.append(", recid=").append(recid);
        sb.append(", limit=").append(limit);
        sb.append(", recordHeight=").append(recordHeight);
        sb.append(", toolbar=").append(toolbar);
        sb.append(", total=").append(total);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", creater=").append(creater);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updater=").append(updater);
        sb.append("]");
        return sb.toString();
    }
}