package com.example.eurekafeignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * class HiController
 * function:
 *
 * @Author chens
 * @Date 2018/8/1
 */
@RestController
public class HiController {

    @Autowired
    private HiServer hiServer;

    @GetMapping("hi")
    public String sayHi(@RequestParam(defaultValue = "eureka", name = "name") String name) {
        return hiServer.sayHi(name);
    }

    @GetMapping("hello")
    public String sayHello(@RequestParam(name = "name") String name) {
        return hiServer.sayHello(name);
    }
}
