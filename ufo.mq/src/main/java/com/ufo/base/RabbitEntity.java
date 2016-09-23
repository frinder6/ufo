package com.ufo.base;

import lombok.Data;

/**
 * Created on 2016/7/31.
 */
@Data
public class RabbitEntity {

    private String queueName;

    private String exchangeName;

    private String exchangeType;

    private String routingKey;

}
