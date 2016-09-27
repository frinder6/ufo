package com.ufo.base;

import com.ufo.dao.QueueLogDao;
import com.ufo.entity.QueueLogEntity;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2016/7/31.
 * <p>
 * 采用装饰器模式，将接收消息需要做的统一处理逻辑（记录流水日志等）都放在该类中
 */
@Component
public class MessageHandlerDecorator implements MessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);

    @Autowired
    private QueueLogDao queueLogDao;

    @Setter
    private MessageHandler messageHandler;


    @Override
    public void handleMessage(Message message) throws SqlFormatException {
        // persist to db
        logger.info("****************************");
        logger.info("persist message to db !");
        logger.info("****************************");
        QueueLogEntity log = new QueueLogEntity();
        BeanUtils.copyProperties(message, log);
        SqlEntity<QueueLogEntity> sqlEntity = new SqlEntity<>();
        sqlEntity.setEntity(log);
        this.queueLogDao.persist(sqlEntity);
        this.messageHandler.handleMessage(message);
        // so images things
        logger.info("****************************");
        logger.info("do some images things !");
        logger.info("****************************");
    }


}
