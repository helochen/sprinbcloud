package com.example.eurekafeignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class HiServer
 * function:
 *
 * @Author chens
 * @Date 2018/8/1
 */
@Service
public class HiServer {

    @Autowired
    private EurekaClientFeign eurekaClientFeign;

    public String sayHi(String name) {
        return eurekaClientFeign.sayHiFeignClientEureka(name);
    }

    public String sayHello(String name) {
        return eurekaClientFeign.sayHelloFeignClientEureka(name);
    }
}
