package com.ufo.mq.base;

import org.springframework.stereotype.Component;

/**
 * Created by frinder_liu on 2016/7/31.
 * <p>
 * 采用装饰器模式，将接收消息需要做的统一处理逻辑（记录流水日志等）都放在该类中
 */
@Component
public class MsgHandlerDecorator implements MsgHandler {

    private MsgHandler msgHandler;

    public MsgHandlerDecorator(MsgHandler msgHandler) {
        this.msgHandler = msgHandler;
    }

    @Override
    public void handleMessage(UFOMessage message) {
        // insert to db
        this.msgHandler.handleMessage(message);
        // so other things
    }


}
