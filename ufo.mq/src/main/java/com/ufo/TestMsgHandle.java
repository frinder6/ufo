package com.ufo;

import com.alibaba.fastjson.JSON;
import com.ufo.base.MessageHandler;
import com.ufo.base.Message;

/**
 * Created on 2016/7/31.
 */
public class TestMsgHandle implements MessageHandler {

    @Override
    public void handleMessage(Message message) {
        System.out.println(JSON.toJSONString(message));
    }
}
