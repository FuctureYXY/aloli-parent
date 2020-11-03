package com.aloli.service;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {

    public void add(String name ){
        System.out.println(name);
        throw  new RuntimeException("dd");
    }

}
