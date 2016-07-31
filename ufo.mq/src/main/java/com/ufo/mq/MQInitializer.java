package com.ufo.mq;

import com.ufo.mq.base.ExchangeType;
import com.ufo.mq.consumer.MsgConsumer;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by frinder_liu on 2016/7/31.
 */
@Component
public class MQInitializer {

    @Autowired
    private CachingConnectionFactory rabbitConnectionFactory;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @PostConstruct
    public void postHandle() throws ExchangeTypeDoNotSupportException, QueueNotExistsException {
        String queueName = "test.queue";
        String exchangeName = "test.queue";
        String routingKey = "test.queue";
        ExchangeType exchangeType = ExchangeType.DIRECT;
        MsgEntity entity = new MsgEntity();
        entity.setQueueName(queueName);
        entity.setExchangeName(exchangeName);
        entity.setRoutingKey(routingKey);
        entity.setExchangeType(exchangeType);

//        MsgProducer productor = new MsgProducer(rabbitConnectionFactory, rabbitAdmin, exchangeType, queueName, exchangeName, routingKey);
//        productor.getRabbitTemplate().convertAndSend("hello");
        MsgConsumer consumer = new MsgConsumer(rabbitConnectionFactory, rabbitAdmin, exchangeType, queueName, exchangeName, routingKey, new TestMsgHandle());
        consumer.startReceive();
    }

}
