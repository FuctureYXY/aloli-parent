package com.aloli.business.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

@Configuration
public class senderConfig {
    @Bean
    public Queue queue(){
        return new Queue("aloli-queue");
    }

}
