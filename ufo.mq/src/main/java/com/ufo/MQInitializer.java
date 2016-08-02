package com.ufo;

import com.alibaba.fastjson.JSON;
import com.ufo.base.*;
import com.ufo.consumer.MsgConsumer;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import com.ufo.productor.MsgProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by frinder_liu on 2016/7/31.
 */
@Component
public class MQInitializer implements ApplicationContextAware {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CachingConnectionFactory rabbitConnectionFactory;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    private ApplicationContext applicationContext;

    @Autowired
    private MsgHandlerDecorator msgHandlerDecorator;

    @PostConstruct
    public void postHandle() throws ExchangeTypeDoNotSupportException, QueueNotExistsException {
        String[] beans = applicationContext.getBeanDefinitionNames();
        logger.info("init beans : ******************************************* ");
        logger.info(JSON.toJSONString(beans));
        logger.info("init beans : ******************************************* ");

        String queueName = "test.queue";
        String exchangeName = "test.queue";
        String routingKey = "test.queue";
        ExchangeType exchangeType = ExchangeType.DIRECT;
        MsgEntity entity = new MsgEntity();
        entity.setQueueName(queueName);
        entity.setExchangeName(exchangeName);
        entity.setRoutingKey(routingKey);
        entity.setExchangeType(exchangeType);

        MsgProducer producer = new MsgProducer(rabbitConnectionFactory, rabbitAdmin, entity);
        UFOMessage message = new UFOMessage();
        message.setContext("hello world...");
        MsgHeader header = new MsgHeader();
        header.setIp("127.0.0.1");
        header.setClassName(UFOMessage.class.toString());
        header.setQueueName(entity.getQueueName());
        header.setExchangeName(entity.getExchangeName());
        header.setRoutingKey(entity.getRoutingKey());
        message.setMsgHeader(header);
        producer.convertAndSend(message);

        this.msgHandlerDecorator.setMsgHandler(new TestMsgHandle());

        MsgConsumer consumer = new MsgConsumer(rabbitConnectionFactory, rabbitAdmin, entity, this.msgHandlerDecorator);
        consumer.startReceive();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
