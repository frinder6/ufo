package com.ufo.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuInfoVO {

    public MenuInfoVO() {
    }

    public MenuInfoVO(Long id, String text, Long parentId, String url) {
        this.id = id;
        this.text = text;
        this.parentId = parentId;
        this.url = url;
    }

    private Long id;

    private String text;

    private Long parentId;

    private String url;

    private String icon;

    private String state;

    private Boolean checked;

    private List<MenuInfoVO> children;

}