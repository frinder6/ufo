package com.ufo.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 2016/7/31.
 */
@Setter
@Getter
public class Message implements Serializable {

    private String host;
    private String className;
    private String queueName;
    private String exchangeName;
    private String routingKey;
    private String context;

}
