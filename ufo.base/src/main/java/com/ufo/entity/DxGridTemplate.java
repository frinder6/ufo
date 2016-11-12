package com.ufo.entity;

import lombok.Data;

/**
 * 表格配置项实体，如：表头，样式等
 * Created by frinder6 on 2016/11/2.
 */
@Data
public class DxGridTemplate {

    private String imagePath;
    private String header;
    private String columnIds;
    private String searchTitles;
    private String searchIds;
    private String searchTypes;
    private String insertTitles;
    private String insertIds;
    private String insertTypes;
    private String modifyTitles;
    private String modifyIds;
    private String modifyTypes;
    private String skin;
    private String pagingSkin;


}
