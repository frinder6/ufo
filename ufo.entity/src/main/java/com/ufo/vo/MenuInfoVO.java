package com.ufo.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuInfoVO {

    private Long id;

    private String text;

    private Long parentId;

    private String url;

    private String icon;

    private String state;

    private Boolean checked;

    private List<MenuInfoVO> children;

}