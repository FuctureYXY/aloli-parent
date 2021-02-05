package com.aloli.business.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {


    @RabbitListener(queues = "aloli-queue")
    public void process(String msg){

        System.out.println(msg);
        throw new RuntimeException("aaaaa");
    }


}
