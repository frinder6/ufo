package com.ufo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by frinder6 on 2016/10/16.
 */
@Data
public class Value implements Serializable {

    public Value() {
    }

    public Value(Object value) {
        this.value = value;
    }

    private Object value;

}
