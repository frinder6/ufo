package com.ufo.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/12.
 */
@Data
public class EasyuiTreeTemplate {

    private Long id;
    private String text;
    private List<EasyuiTreeTemplate> children;

}
