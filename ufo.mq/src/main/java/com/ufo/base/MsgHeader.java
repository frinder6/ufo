package com.ufo.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MsgHeader implements Serializable {
    private String ip;
    private String className;
    private String queueName;
    private String exchangeName;
    private String routingKey;
}
