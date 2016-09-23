package com.ufo.base;

import com.alibaba.fastjson.JSON;
import com.ufo.consumer.Consumer;
import com.ufo.productor.Producer;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created on 2016/7/31.
 */
@Getter
public abstract class RabbitManager {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 保存所有消息生产者
     */
    public static final ConcurrentMap<String, Producer> PRODUCER = new ConcurrentHashMap<>();


    /**
     * 保存所有消息消费者
     */
    public static final ConcurrentMap<String, Consumer> CONSUMER = new ConcurrentHashMap<>();


    private CachingConnectionFactory rabbitConnectionFactory;

    private RabbitAdmin rabbitAdmin;

    private RabbitEntity msgEntity;


    /**
     * 生成对象
     */
    private BindingHandler bindingHandler;

    private RabbitTemplate rabbitTemplate;


    public RabbitManager(CachingConnectionFactory rabbitConnectionFactory, RabbitAdmin rabbitAdmin, RabbitEntity msgEntity) throws ExchangeTypeDoNotSupportException, QueueNotExistsException {
        logger.info("**************************************begin init !");
        this.rabbitConnectionFactory = rabbitConnectionFactory;
        this.rabbitAdmin = rabbitAdmin;
        this.msgEntity = msgEntity;
        // bindingHandler
        this.bindingHandler = new BindingHandler(msgEntity);
        // rabbitTemplate
        this.rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory);
        this.rabbitTemplate.setQueue(msgEntity.getQueueName());
        this.rabbitTemplate.setExchange(msgEntity.getExchangeName());
        this.rabbitTemplate.setRoutingKey(msgEntity.getRoutingKey());
        rabbitAdmin.declareQueue(bindingHandler.getQueue());
        rabbitAdmin.declareExchange(bindingHandler.getExchange());
        rabbitAdmin.declareBinding(bindingHandler.getBinding());
        try {
            logger.info(JSON.toJSONString(this));
        } catch (Exception e) {
        }
        logger.info("**************************************finish init !");
    }


    protected RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }


    /**
     * 内部类：处理绑定关系
     */
    @Getter
    class BindingHandler {

        private final Logger logger = LoggerFactory.getLogger(BindingHandler.class);

        private Queue queue;

        private Exchange exchange;

        private Binding binding;

        public BindingHandler(RabbitEntity rabbitEntity) throws QueueNotExistsException, ExchangeTypeDoNotSupportException {
            String queueName = rabbitEntity.getQueueName();
            String exchangeName = rabbitEntity.getExchangeName();
            String routingKey = rabbitEntity.getRoutingKey();
            String exchangeType = rabbitEntity.getExchangeType();
            logger.info("binding info : [ queue : " + queueName + ", exchange : " + exchangeName + ", routingKey : " + routingKey + " ] !");
            if (StringUtils.isEmpty(queueName)) {
                throw new QueueNotExistsException(queueName);
            }
            this.queue = new Queue(queueName);
            try {
                if (ExchangeTypes.DIRECT.equalsIgnoreCase(exchangeType)) {
                    this.exchange = new DirectExchange(exchangeName);
                    this.binding = BindingBuilder.bind(queue).to((DirectExchange) exchange).with(routingKey);
                } else if (ExchangeTypes.TOPIC.equalsIgnoreCase(exchangeType)) {
                    this.exchange = new TopicExchange(exchangeName);
                    this.binding = BindingBuilder.bind(queue).to((TopicExchange) exchange).with(routingKey);
                } else if (ExchangeTypes.FANOUT.equalsIgnoreCase(exchangeType)) {
                    this.exchange = new FanoutExchange(exchangeName);
                    this.binding = BindingBuilder.bind(queue).to((FanoutExchange) exchange);
                } else {
                    throw new ExchangeTypeDoNotSupportException(exchangeType);
                }
                logger.info("binding result : " + JSON.toJSONString(this));
            } catch (Exception e) {
                logger.info("binding result : [ queue : " + queueName + ", exchange : " + exchangeName + ", routingKey : " + routingKey + " ] !");
            }
        }

    }

}
