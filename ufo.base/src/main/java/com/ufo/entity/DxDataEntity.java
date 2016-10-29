package com.ufo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by frinder6 on 2016/10/24.
 */
@Data
public class DxDataEntity implements Serializable {

    private int total_count;

    private int pos;

    private List<Serializable> data;


}
