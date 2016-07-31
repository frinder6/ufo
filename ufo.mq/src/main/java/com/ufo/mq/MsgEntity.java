package com.ufo.mq;

import com.ufo.mq.base.ExchangeType;
import lombok.Data;

/**
 * Created by frinder_liu on 2016/7/31.
 */
@Data
public class MsgEntity {

    private ExchangeType exchangeType;

    private String queueName;

    private String exchangeName;

    private String routingKey;

}
