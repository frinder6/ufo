package com.ufo;

import com.alibaba.fastjson.JSON;
import com.ufo.base.MsgHandler;
import com.ufo.base.UFOMessage;

/**
 * Created by frinder_liu on 2016/7/31.
 */
public class TestMsgHandle implements MsgHandler {

    @Override
    public void handleMessage(UFOMessage message) {
        System.out.println(JSON.toJSONString(message));
    }
}
