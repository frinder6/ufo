package com.ufo.exception;

/**
 * Created on 2016/7/31.
 *
 */
public class QueueNotExistsException extends Exception {

    public QueueNotExistsException(String queueName) {
        super("this queue " + queueName + " doesn't exists, please call the administrator !");
    }

}
