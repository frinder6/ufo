package com.ufo.mq.base;

import com.alibaba.fastjson.JSON;
import com.ufo.mq.consumer.MsgConsumer;
import com.ufo.mq.productor.MsgProducer;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by frinder_liu on 2016/7/31.
 */
@Getter
public class MsgManager {

    protected final Logger logger = Logger.getLogger(getClass());

    /**
     * 保存所有消息生产者
     */
    public static final ConcurrentMap<String, MsgProducer> PRODUCTOR = new ConcurrentHashMap<>();


    /**
     * 保存所有消息消费者
     */
    public static final ConcurrentMap<String, MsgConsumer> CONSUMER = new ConcurrentHashMap<>();


    private CachingConnectionFactory rabbitConnectionFactory;

    private RabbitAdmin rabbitAdmin;

    private ExchangeType exchangeType;

    private String queueName;

    private String exchangeName;

    private String routingKey;


    /**
     * 生成对象
     */
    private BindingHandler bindingHandler;

    private RabbitTemplate rabbitTemplate;


    public MsgManager(CachingConnectionFactory rabbitConnectionFactory, RabbitAdmin rabbitAdmin, ExchangeType exchangeType, String queueName, String exchangeName, String routingKey) throws ExchangeTypeDoNotSupportException, QueueNotExistsException {
        logger.info("**************************************begin init !");
        this.rabbitConnectionFactory = rabbitConnectionFactory;
        this.rabbitAdmin = rabbitAdmin;
        this.exchangeType = exchangeType;
        this.queueName = queueName;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
        // bindingHandler
        this.bindingHandler = new BindingHandler(queueName, exchangeName, routingKey, exchangeType);
        // rabbitTemplate
        this.rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory);
        this.rabbitTemplate.setQueue(queueName);
        this.rabbitTemplate.setExchange(exchangeName);
        this.rabbitTemplate.setRoutingKey(routingKey);
        rabbitAdmin.declareQueue(bindingHandler.getQueue());
        rabbitAdmin.declareExchange(bindingHandler.getExchange());
        rabbitAdmin.declareBinding(bindingHandler.getBinding());
        try {
            logger.info(JSON.toJSONString(this));
        } catch (Exception e) {
        }
        logger.info("**************************************finish init !");
    }


    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

}
