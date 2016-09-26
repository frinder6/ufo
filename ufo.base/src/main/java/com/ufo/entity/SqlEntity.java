package com.ufo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frinder_liu on 2016/8/13.
 */

@Data
public class SqlEntity<T> implements Serializable {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 操作列
     */
    private List<String> valueCols = new ArrayList<>();

    /**
     * 条件列
     */
    private List<String> whereCols = new ArrayList<>();

    /**
     * 实体
     */
    private T entity;


    /**
     * 实体类型
     */
    public Class<?> getEntityType(){
        if (null == entity){
            throw new IllegalArgumentException("实体为null，不符合程序要求，请检查代码修正此错误！");
        }
        return entity.getClass();
    }



}
