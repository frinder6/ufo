package com.ufo.mq;

import com.ufo.mq.base.MsgHandler;

/**
 * Created by frinder_liu on 2016/7/31.
 */
public class TestMsgHandle implements MsgHandler {

    @Override
    public void handleMessage(Object message) {
        System.out.println(message);
    }
}
