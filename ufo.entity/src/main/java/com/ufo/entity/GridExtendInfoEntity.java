package com.ufo.entity;

import java.util.Date;

public class GridExtendInfoEntity {
    private Long id;

    private Long gridId;

    private String gridName;

    private String url;

    private String dataOptions;

    private String addUrl;

    private String removeUrl;

    private String modifyUrl;

    private Boolean fitColumns;

    private Boolean stripe;

    private Boolean nowrap;

    private Boolean pagination;

    private Boolean rownumbers;

    private Boolean singleSelect;

    private Boolean multiSort;

    private String pagePosition;

    private Integer pageSize;

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

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName == null ? null : gridName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDataOptions() {
        return dataOptions;
    }

    public void setDataOptions(String dataOptions) {
        this.dataOptions = dataOptions == null ? null : dataOptions.trim();
    }

    public String getAddUrl() {
        return addUrl;
    }

    public void setAddUrl(String addUrl) {
        this.addUrl = addUrl == null ? null : addUrl.trim();
    }

    public String getRemoveUrl() {
        return removeUrl;
    }

    public void setRemoveUrl(String removeUrl) {
        this.removeUrl = removeUrl == null ? null : removeUrl.trim();
    }

    public String getModifyUrl() {
        return modifyUrl;
    }

    public void setModifyUrl(String modifyUrl) {
        this.modifyUrl = modifyUrl == null ? null : modifyUrl.trim();
    }

    public Boolean getFitColumns() {
        return fitColumns;
    }

    public void setFitColumns(Boolean fitColumns) {
        this.fitColumns = fitColumns;
    }

    public Boolean getStripe() {
        return stripe;
    }

    public void setStripe(Boolean stripe) {
        this.stripe = stripe;
    }

    public Boolean getNowrap() {
        return nowrap;
    }

    public void setNowrap(Boolean nowrap) {
        this.nowrap = nowrap;
    }

    public Boolean getPagination() {
        return pagination;
    }

    public void setPagination(Boolean pagination) {
        this.pagination = pagination;
    }

    public Boolean getRownumbers() {
        return rownumbers;
    }

    public void setRownumbers(Boolean rownumbers) {
        this.rownumbers = rownumbers;
    }

    public Boolean getSingleSelect() {
        return singleSelect;
    }

    public void setSingleSelect(Boolean singleSelect) {
        this.singleSelect = singleSelect;
    }

    public Boolean getMultiSort() {
        return multiSort;
    }

    public void setMultiSort(Boolean multiSort) {
        this.multiSort = multiSort;
    }

    public String getPagePosition() {
        return pagePosition;
    }

    public void setPagePosition(String pagePosition) {
        this.pagePosition = pagePosition == null ? null : pagePosition.trim();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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
        GridExtendInfoEntity other = (GridExtendInfoEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGridId() == null ? other.getGridId() == null : this.getGridId().equals(other.getGridId()))
            && (this.getGridName() == null ? other.getGridName() == null : this.getGridName().equals(other.getGridName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getDataOptions() == null ? other.getDataOptions() == null : this.getDataOptions().equals(other.getDataOptions()))
            && (this.getAddUrl() == null ? other.getAddUrl() == null : this.getAddUrl().equals(other.getAddUrl()))
            && (this.getRemoveUrl() == null ? other.getRemoveUrl() == null : this.getRemoveUrl().equals(other.getRemoveUrl()))
            && (this.getModifyUrl() == null ? other.getModifyUrl() == null : this.getModifyUrl().equals(other.getModifyUrl()))
            && (this.getFitColumns() == null ? other.getFitColumns() == null : this.getFitColumns().equals(other.getFitColumns()))
            && (this.getStripe() == null ? other.getStripe() == null : this.getStripe().equals(other.getStripe()))
            && (this.getNowrap() == null ? other.getNowrap() == null : this.getNowrap().equals(other.getNowrap()))
            && (this.getPagination() == null ? other.getPagination() == null : this.getPagination().equals(other.getPagination()))
            && (this.getRownumbers() == null ? other.getRownumbers() == null : this.getRownumbers().equals(other.getRownumbers()))
            && (this.getSingleSelect() == null ? other.getSingleSelect() == null : this.getSingleSelect().equals(other.getSingleSelect()))
            && (this.getMultiSort() == null ? other.getMultiSort() == null : this.getMultiSort().equals(other.getMultiSort()))
            && (this.getPagePosition() == null ? other.getPagePosition() == null : this.getPagePosition().equals(other.getPagePosition()))
            && (this.getPageSize() == null ? other.getPageSize() == null : this.getPageSize().equals(other.getPageSize()))
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
        result = prime * result + ((getGridName() == null) ? 0 : getGridName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getDataOptions() == null) ? 0 : getDataOptions().hashCode());
        result = prime * result + ((getAddUrl() == null) ? 0 : getAddUrl().hashCode());
        result = prime * result + ((getRemoveUrl() == null) ? 0 : getRemoveUrl().hashCode());
        result = prime * result + ((getModifyUrl() == null) ? 0 : getModifyUrl().hashCode());
        result = prime * result + ((getFitColumns() == null) ? 0 : getFitColumns().hashCode());
        result = prime * result + ((getStripe() == null) ? 0 : getStripe().hashCode());
        result = prime * result + ((getNowrap() == null) ? 0 : getNowrap().hashCode());
        result = prime * result + ((getPagination() == null) ? 0 : getPagination().hashCode());
        result = prime * result + ((getRownumbers() == null) ? 0 : getRownumbers().hashCode());
        result = prime * result + ((getSingleSelect() == null) ? 0 : getSingleSelect().hashCode());
        result = prime * result + ((getMultiSort() == null) ? 0 : getMultiSort().hashCode());
        result = prime * result + ((getPagePosition() == null) ? 0 : getPagePosition().hashCode());
        result = prime * result + ((getPageSize() == null) ? 0 : getPageSize().hashCode());
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
        sb.append(", gridName=").append(gridName);
        sb.append(", url=").append(url);
        sb.append(", dataOptions=").append(dataOptions);
        sb.append(", addUrl=").append(addUrl);
        sb.append(", removeUrl=").append(removeUrl);
        sb.append(", modifyUrl=").append(modifyUrl);
        sb.append(", fitColumns=").append(fitColumns);
        sb.append(", stripe=").append(stripe);
        sb.append(", nowrap=").append(nowrap);
        sb.append(", pagination=").append(pagination);
        sb.append(", rownumbers=").append(rownumbers);
        sb.append(", singleSelect=").append(singleSelect);
        sb.append(", multiSort=").append(multiSort);
        sb.append(", pagePosition=").append(pagePosition);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", creater=").append(creater);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updater=").append(updater);
        sb.append("]");
        return sb.toString();
    }
}