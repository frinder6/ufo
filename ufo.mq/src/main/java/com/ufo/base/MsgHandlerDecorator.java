package com.ufo.base;

import com.ufo.dao.QueueLogDao;
import com.ufo.entity.QueueLog;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

/**
 * Created by frinder_liu on 2016/7/31.
 * <p>
 * 采用装饰器模式，将接收消息需要做的统一处理逻辑（记录流水日志等）都放在该类中
 */
@Component
public class MsgHandlerDecorator implements MsgHandler {

    private static final Logger logger = LoggerFactory.getLogger(MsgHandlerDecorator.class);

    @Autowired
    private QueueLogDao queueLogDao;

    @Setter
    private MsgHandler msgHandler;


    @Override
    public void handleMessage(UFOMessage message) {
        // insert to db
        logger.info("****************************");
        logger.info("insert message to db !");
        logger.info("****************************");
        QueueLog log = new QueueLog();
        log.setIp(message.getMsgHeader().getIp());
        log.setQueueName(message.getMsgHeader().getQueueName());
        log.setExchangeName(message.getMsgHeader().getExchangeName());
        log.setRoutingKey(message.getMsgHeader().getRoutingKey());
        log.setClassName(message.getMsgHeader().getClassName());
        log.setContext(message.getContext());
        this.queueLogDao.insert(log);
        this.msgHandler.handleMessage(message);
        // so other things
        logger.info("****************************");
        logger.info("do some other things !");
        logger.info("****************************");
    }


}
