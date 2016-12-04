package com.ufo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frinder6 on 2016/11/23.
 */
@Data
public class EasyuiFormTemplate {

    private StringBuilder search;
    private StringBuilder insert;
    private StringBuilder modify;

    private List<EasyuiFieldTemplate> templateList = new ArrayList<>();

}
