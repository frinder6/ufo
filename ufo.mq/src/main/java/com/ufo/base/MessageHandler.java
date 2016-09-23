package com.ufo.base;

import com.ufo.exception.SqlFormatException;

/**
 * Created on 2016/7/31.
 */
public interface MessageHandler {

    void handleMessage(Message message) throws SqlFormatException;

}
