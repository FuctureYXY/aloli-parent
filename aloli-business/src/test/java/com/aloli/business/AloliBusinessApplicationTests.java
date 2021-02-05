package com.aloli.business;

import com.aloli.business.rabbitmq.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AloliBusinessApplicationTests {
    @Autowired
    private Sender sender;
    @Test
    void contextLoads() {
        this.sender.send();

    }

}
