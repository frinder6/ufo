package com.ufo;

import com.alibaba.fastjson.JSON;
import com.ufo.base.*;
import com.ufo.consumer.Consumer;
import com.ufo.entity.QueueInfoEntity;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.ExchangeTypeDoNotSupportException;
import com.ufo.exception.QueueNotExistsException;
import com.ufo.exception.SqlFormatException;
import com.ufo.productor.Producer;
import com.ufo.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2016/7/31.
 */
@Component
public class RabbitInitializer implements ApplicationContextAware {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CachingConnectionFactory rabbitConnectionFactory;

    @Autowired
    private AmqpAdmin amqpAdmin;

    private ApplicationContext applicationContext;

    @Autowired
    private MessageHandlerDecorator messageHandlerDecorator;

    @Autowired
    private IService<QueueInfoEntity> queueInfoService;


//    @PostConstruct
    public void postHandle() throws ExchangeTypeDoNotSupportException, QueueNotExistsException, SqlFormatException {
        String[] beans = applicationContext.getBeanDefinitionNames();
        logger.info("init beans : ******************************************* ");
        logger.info(JSON.toJSONString(beans));
        logger.info("init beans : ******************************************* ");

        QueueInfoEntity entity = new QueueInfoEntity();
        entity.setStatus((byte) 1);
        String[] whereCols = {"status"};
        SqlEntity<QueueInfoEntity> sqlEntity = new SqlEntity<>();
        sqlEntity.setEntity(entity);
        sqlEntity.setEntityType(QueueInfoEntity.class);
        sqlEntity.setWhereCols(Arrays.asList(whereCols));
        List<QueueInfoEntity> queueList = this.queueInfoService.selectForList(sqlEntity);

        for (QueueInfoEntity queue : queueList) {
            RabbitEntity rabbitEntity = new RabbitEntity();
            BeanUtils.copyProperties(queue, rabbitEntity);
            // producer
            new Producer(rabbitConnectionFactory, amqpAdmin, rabbitEntity);
            // consumer
            this.messageHandlerDecorator.setMessageHandler(new TestMsgHandle());
            new Consumer(rabbitConnectionFactory, amqpAdmin, rabbitEntity, this.messageHandlerDecorator).startReceive();
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @PreDestroy
    public void destory(){
        RabbitManager.destory();
    }

}
