package com.ufo.consumer;

import com.alibaba.fastjson.JSON;
import com.ufo.base.RabbitEntity;
import com.ufo.base.MessageHandler;
import com.ufo.base.RabbitManager;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import lombok.Getter;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

/**
 * Created on 2016/7/31.
 */
@Getter
public class Consumer extends RabbitManager {

    private SimpleMessageListenerContainer simpleMessageListenerContainer;

    private MessageHandler messageHandler;

    /**
     * @param rabbitConnectionFactory
     * @param amqpAdmin
     * @param msgEntity
     * @param msgHandler
     * @throws ExchangeTypeDoNotSupportException
     * @throws QueueNotExistsException
     */
    public Consumer(CachingConnectionFactory rabbitConnectionFactory, AmqpAdmin amqpAdmin, RabbitEntity msgEntity, MessageHandler msgHandler) throws ExchangeTypeDoNotSupportException, QueueNotExistsException {
        super(rabbitConnectionFactory, amqpAdmin, msgEntity);
        logger.info("*********************************consumer begin init !");
        this.simpleMessageListenerContainer = new SimpleMessageListenerContainer(rabbitConnectionFactory);
        this.messageHandler = msgHandler;
        MessageListenerAdapter adapter = new MessageListenerAdapter();
        adapter.setDelegate(msgHandler);
        adapter.setDefaultListenerMethod("handleMessage");
        this.simpleMessageListenerContainer.setMessageListener(adapter);
        this.simpleMessageListenerContainer.setQueueNames(msgEntity.getQueueName());
        CONSUMER.put(msgEntity.getQueueName(), this);
        try {
            logger.info(JSON.toJSONString(this));
        } catch (Exception e) {
        }
        logger.info("*********************************consumer finish init !");
    }

    /**
     * stop
     *
     * @return
     */
    public int stopReceive() {
        logger.info("consumer stop to receive msg !");
        if (null != simpleMessageListenerContainer && simpleMessageListenerContainer.isRunning()) {
            simpleMessageListenerContainer.stop();
            return 1;
        }
        return 0;
    }


    /**
     * start
     *
     * @return
     */
    public int startReceive() {
        logger.info("consumer start to receive msg !");
        if (null != simpleMessageListenerContainer && !simpleMessageListenerContainer.isRunning()) {
            simpleMessageListenerContainer.start();
            return 1;
        }
        return 0;
    }

}
