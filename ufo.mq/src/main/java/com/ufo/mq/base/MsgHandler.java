package com.ufo.mq.base;

/**
 * Created by frinder_liu on 2016/7/31.
 */
public interface MsgHandler {

    void handleMessage(UFOMessage message);

}
