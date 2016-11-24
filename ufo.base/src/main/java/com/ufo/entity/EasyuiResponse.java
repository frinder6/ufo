package com.ufo.entity;

import lombok.Data;

/**
 * Created by frinder6 on 2016/11/17.
 */
@Data
public class EasyuiResponse {

    public static final String SUCCESS = "success";

    public static final String ERROR = "error";

    public EasyuiResponse(String status) {
        this.status = status;
    }

    public EasyuiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }


    private String status;
    private String message;
}
