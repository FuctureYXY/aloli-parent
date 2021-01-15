package com.aloli.security.combine;

import com.aloli.security.api.User;
import com.aloli.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
@Slf4j
public class Test1 {
    @Autowired
    private UserService userService;
    @Test
    public void   a1() throws Exception{


        CompletableFuture<Void> completableFuture =  CompletableFuture.runAsync(
                ()->{
                    try {
                        log.info("aa");
                        TimeUnit.SECONDS.sleep(5);
                        log.info("aa1");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
        );
        log.info("谁会先执行呢2");
        completableFuture.get();
        log.info("谁会先执行呢");

       // TimeUnit.SECONDS.sleep(6);
        log.info("谁会先执行呢3d");
    }
}
