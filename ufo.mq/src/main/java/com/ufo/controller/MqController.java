package com.ufo.controller;

import com.ufo.base.Message;
import com.ufo.base.RabbitManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder6 on 2016/9/26.
 */
@RestController
public class MqController {

    @RequestMapping("send")
    public String send(HttpServletRequest request){
        String queueName = "default.queue.direct";
        System.out.println(request.getRequestURI());
        Message message = new Message(request.getRemoteHost(), getClass().getName(), queueName, "", "", "hello rabbitmq!");
        RabbitManager.PRODUCER.get(queueName).convertAndSend(message);
        return "ok";
    }

}
