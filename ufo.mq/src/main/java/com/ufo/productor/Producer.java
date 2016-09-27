package com.ufo.productor;

import com.alibaba.fastjson.JSON;
import com.ufo.base.RabbitEntity;
import com.ufo.base.RabbitManager;
import com.ufo.base.Message;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import lombok.Getter;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

/**
 * Created on 2016/7/31.
 */
@Getter
public class Producer extends RabbitManager {

    /**
     *
     * @param rabbitConnectionFactory
     * @param amqpAdmin
     * @param msgEntity
     * @throws ExchangeTypeDoNotSupportException
     * @throws QueueNotExistsException
     */
    public Producer(CachingConnectionFactory rabbitConnectionFactory, AmqpAdmin amqpAdmin, RabbitEntity msgEntity) throws ExchangeTypeDoNotSupportException, QueueNotExistsException {
        super(rabbitConnectionFactory, amqpAdmin, msgEntity);
        logger.info("********************************* producer begin init !");
        PRODUCER.put(msgEntity.getQueueName(), this);
        try {
            logger.info(JSON.toJSONString(this));
        } catch (Exception e) {
        }
        logger.info("********************************* producer finish init !");
    }

    /**
     *
     * @param message
     */
    public void convertAndSend(Message message){
        this.getRabbitTemplate().convertAndSend(message);
    }


}
