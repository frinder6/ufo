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

    public Message() {
    }

    public Message(String host, String className, String queueName, String exchangeName, String routingKey, String context) {
        this.host = host;
        this.className = className;
        this.queueName = queueName;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
        this.context = context;
    }

    private String host;
    private String className;
    private String queueName;
    private String exchangeName;
    private String routingKey;
    private String context;

}
