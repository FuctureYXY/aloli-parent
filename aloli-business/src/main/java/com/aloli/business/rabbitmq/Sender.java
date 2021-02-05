package com.aloli.business.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send(){
        String msg="aaa-- aloli"+new Date();
        this.amqpTemplate.convertAndSend("aloli-queue",msg);
    }
}
