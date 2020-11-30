package com.aloli.security.test;

import com.aloli.security.AloliApplication;
import com.aloli.security.service.DemoAnnotationService;
import com.aloli.security.service.DemoMethodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = AloliApplication.class)
public class PSecurityApplicationTests {

    @Autowired
    private DemoAnnotationService demoAnnotationService;
    @Autowired
    private DemoMethodService demoMethodService;

    @Test
    public void test() {
        demoAnnotationService.add();
       // demoMethodService.add("aa");
    }


}
