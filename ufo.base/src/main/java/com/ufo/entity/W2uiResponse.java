package com.ufo.entity;

import lombok.Data;

/**
 * Created by frinder6 on 2016/11/17.
 */
@Data
public class W2uiResponse {

    public static final String SUCCESS = "success";

    public static final String ERROR = "error";

    public W2uiResponse(String status) {
        this.status = status;
    }

    public W2uiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }


    private String status;
    private String message;
}
