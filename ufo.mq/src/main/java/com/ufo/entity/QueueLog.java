package com.ufo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by frinder_liu on 2016/8/1.
 */
@Data
public class QueueLog implements Serializable {
    private Long id;
    private String ip;
    private String queueName;
    private String exchangeName;
    private String routingKey;
    private String className;
    private String context;
}
