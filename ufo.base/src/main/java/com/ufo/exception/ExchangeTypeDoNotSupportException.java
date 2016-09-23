package com.ufo.exception;

/**
 * Created on 2016/7/31.
 */
public class ExchangeTypeDoNotSupportException extends Exception {

    public ExchangeTypeDoNotSupportException(String exchangeType) {
        super("this " + exchangeType + " doesn't support, please call the administrator !");
    }
}
