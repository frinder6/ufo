package com.ufo.mq.base;

import com.alibaba.fastjson.JSON;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.util.StringUtils;

/**
 * Created by frinder_liu on 2016/7/31.
 */

@Getter
public class BindingHandler {

    private final Logger logger = Logger.getLogger(BindingHandler.class);

    private Queue queue;

    private Exchange exchange;

    private Binding binding;

    public BindingHandler(String queueName, String exchangeName, String routingKey, ExchangeType exchangeType) throws QueueNotExistsException, ExchangeTypeDoNotSupportException {
        logger.info("binding info : [ queue : " + queueName + ", exchange : " + exchangeName + ", routingKey : " + routingKey + " ] !");
        if (StringUtils.isEmpty(queueName)) {
            throw new QueueNotExistsException(queueName);
        }
        this.queue = new Queue(queueName);
        if (exchangeType == ExchangeType.DIRECT) {
            this.exchange = new DirectExchange(exchangeName);
            this.binding = BindingBuilder.bind(queue).to((DirectExchange) exchange).with(routingKey);
        } else if (exchangeType == ExchangeType.FANOUT) {
            this.exchange = new FanoutExchange(exchangeName);
            this.binding = BindingBuilder.bind(queue).to((FanoutExchange) exchange);
        } else if (exchangeType == ExchangeType.TOPIC) {
            this.exchange = new TopicExchange(exchangeName);
            this.binding = BindingBuilder.bind(queue).to((TopicExchange) exchange).with(routingKey);
        } else {
            throw new ExchangeTypeDoNotSupportException(exchangeType.toString());
        }
        try {
            logger.info("binding result : " + JSON.toJSONString(this));
        } catch (Exception e) {
            logger.info("binding result : [ queue : " + queueName + ", exchange : " + exchangeName + ", routingKey : " + routingKey + " ] !");
        }
    }

}
