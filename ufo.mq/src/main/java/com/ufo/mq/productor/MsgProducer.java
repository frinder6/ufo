package com.ufo.mq.productor;

import com.alibaba.fastjson.JSON;
import com.ufo.mq.base.ExchangeType;
import com.ufo.mq.base.MsgManager;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import lombok.Getter;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

/**
 * Created on 2016/7/31.
 */
@Getter
public class MsgProducer extends MsgManager {


    public MsgProducer(CachingConnectionFactory rabbitConnectionFactory, RabbitAdmin rabbitAdmin, ExchangeType exchangeType, String queueName, String exchangeName, String routingKey) throws ExchangeTypeDoNotSupportException, QueueNotExistsException {
        super(rabbitConnectionFactory, rabbitAdmin, exchangeType, queueName, exchangeName, routingKey);
        logger.info("********************************* producer begin init !");
        PRODUCTOR.put(queueName, this);
        try {
            logger.info(JSON.toJSONString(this));
        } catch (Exception e) {
        }
        logger.info("********************************* producer finish init !");
    }
}
