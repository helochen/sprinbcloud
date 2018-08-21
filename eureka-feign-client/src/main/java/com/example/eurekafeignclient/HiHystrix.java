package com.example.eurekafeignclient;

import org.springframework.stereotype.Component;

/**
 * Enum HiHystrix
 * function:
 *
 * @Author chens
 * @Date 2018/8/10 23:12
 */
@Component
public class HiHystrix implements EurekaClientFeign{


    @Override
    public String sayHiFeignClientEureka(String name) {
        return "hi,name sorry,error";
    }

    @Override
    public String sayHelloFeignClientEureka(String hello) {
        return "say hello?";
    }
}
