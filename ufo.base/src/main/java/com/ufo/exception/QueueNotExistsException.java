package com.ufo.exception;

/**
 * Created by frinder_liu on 2016/7/31.
 */
public class QueueNotExistsException extends Exception {

    public QueueNotExistsException(String queueName) {
        super("this queue " + queueName + " doesn't exists, please call the administrator !");
    }

}
