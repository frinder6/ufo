package com.ufo.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/12.
 */
@Data
public class MenuTreeInfoVO {

    private Long id;
    private String text;
    private List<MenuTreeInfoVO> item;

}
