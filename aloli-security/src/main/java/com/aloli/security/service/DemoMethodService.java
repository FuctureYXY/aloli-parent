package com.aloli.security.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {



    //@Async("syncPoolTaskExecutor")
    public void addd(String name ){
        System.out.println(name);
        //Integer x = 1/0;
       throw  new RuntimeException("dd");
    }

}
