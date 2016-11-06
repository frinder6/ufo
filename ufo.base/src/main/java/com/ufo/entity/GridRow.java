package com.ufo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frinder6 on 2016/11/6.
 */
@Data
public class GridRow {

    private Object id;
    private List<Object> data = new ArrayList();

}
