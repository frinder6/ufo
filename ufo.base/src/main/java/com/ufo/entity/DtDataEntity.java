package com.ufo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by frinder6 on 2016/10/24.
 */
@Data
public class DtDataEntity implements Serializable {

    private List<Serializable> data;

    private int start = 0;

    private int length = 10;

    private int recordsTotal;

    private int recordsFiltered;

}
