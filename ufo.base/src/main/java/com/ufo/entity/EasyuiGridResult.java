package com.ufo.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by frinder6 on 2016/11/15.
 */
@Data
public class EasyuiGridResult {

    private int total;
    private Object rows;


    /**
     * empty instance
     *
     * @return
     */
    public static EasyuiGridResult getEmptyInstance() {
        EasyuiGridResult result = new EasyuiGridResult();
        result.setTotal(0);
        result.setRows(new ArrayList<>());
        return result;
    }

}
