package com.ufo.entity;

import lombok.Data;

/**
 * Created by frinder6 on 2016/11/20.
 */

@Data
public class W2uiComboTemplate {

    public W2uiComboTemplate() {
    }

    public W2uiComboTemplate(long id, String value) {
        this.id = id;
        this.value = value;
    }

    private long id;
    private String value;
}
