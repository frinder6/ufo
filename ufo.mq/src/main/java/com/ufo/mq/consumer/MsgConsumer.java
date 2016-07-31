package com.ufo.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.ufo.mq.base.ExchangeType;
import com.ufo.mq.base.MsgHandler;
import com.ufo.mq.base.MsgHandlerDecorator;
import com.ufo.mq.base.MsgManager;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

/**
 * Created on 2016/7/31.
 */
public class MsgConsumer extends MsgManager {

    private SimpleMessageListenerContainer simpleMessageListenerContainer;

    private MsgHandler msgHandler;

    public MsgConsumer(CachingConnectionFactory rabbitConnectionFactory, RabbitAdmin rabbitAdmin, ExchangeType exchangeType, String queueName, String exchangeName, String routingKey, MsgHandler msgHandler) throws ExchangeTypeDoNotSupportException, QueueNotExistsException {
        super(rabbitConnectionFactory, rabbitAdmin, exchangeType, queueName, exchangeName, routingKey);
        logger.info("*********************************consumer begin init !");
        this.simpleMessageListenerContainer = new SimpleMessageListenerContainer(rabbitConnectionFactory);
        this.msgHandler = msgHandler;
        MessageListenerAdapter adapter = new MessageListenerAdapter();
        /**
         * 采用装饰模式，在接收到消息后执行一些通用操作（记录日志表等）后再执行业务处理
         */
        MsgHandlerDecorator decorator = new MsgHandlerDecorator(msgHandler);
        adapter.setDelegate(decorator);
        adapter.setDefaultListenerMethod("handleMessage");
        this.simpleMessageListenerContainer.setMessageListener(adapter);
        this.simpleMessageListenerContainer.setQueueNames(queueName);
        CONSUMER.put(queueName, this);
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
