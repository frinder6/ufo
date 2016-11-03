package com.ufo.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuInfoVO {

    public MenuInfoVO() {
    }

    public MenuInfoVO(Long id, String title, Long parentId, String url) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.url = url;
    }

    private Long id;

    private String title;

    private Long parentId;

    private String url;

    private String icon;

    private List<MenuInfoVO> children;

}