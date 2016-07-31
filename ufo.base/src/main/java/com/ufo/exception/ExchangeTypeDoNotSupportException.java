package com.ufo.exception;

/**
 * Created by frinder_liu on 2016/7/31.
 */
public class ExchangeTypeDoNotSupportException extends Exception {

    public ExchangeTypeDoNotSupportException(String exchangeType) {
        super("this " + exchangeType + " doesn't support, please call the administrator !");
    }
}
