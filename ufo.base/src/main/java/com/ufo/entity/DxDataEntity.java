package com.ufo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by frinder6 on 2016/10/24.
 */
@Data
public class DxDataEntity implements Serializable {

    private int total_count;

    private int pos;

    private List<Row> rows = new ArrayList<>();

    @Data
    public static class Row implements Serializable {
        private Long id;
        private Collection<Object> data;
    }

}
