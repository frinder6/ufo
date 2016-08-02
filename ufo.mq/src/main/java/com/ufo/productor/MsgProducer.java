package com.ufo.productor;

import com.alibaba.fastjson.JSON;
import com.ufo.base.MsgEntity;
import com.ufo.base.MsgManager;
import com.ufo.base.UFOMessage;
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

    /**
     *
     * @param rabbitConnectionFactory
     * @param rabbitAdmin
     * @param msgEntity
     * @throws ExchangeTypeDoNotSupportException
     * @throws QueueNotExistsException
     */
    public MsgProducer(CachingConnectionFactory rabbitConnectionFactory, RabbitAdmin rabbitAdmin, MsgEntity msgEntity) throws ExchangeTypeDoNotSupportException, QueueNotExistsException {
        super(rabbitConnectionFactory, rabbitAdmin, msgEntity);
        logger.info("********************************* producer begin init !");
        PRODUCTOR.put(msgEntity.getQueueName(), this);
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
    public void convertAndSend(UFOMessage message){
        this.getRabbitTemplate().convertAndSend(message);
    }


}
