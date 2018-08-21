package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * class HelloController
 * function:
 *
 * @Author chens
 * @Date 2018/7/24
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "hi")
    public String hi(@RequestParam(name = "name" ,required = false , defaultValue = "feign") String name) {
        return "hello world\t" + port + "\t" + name;
    }
}
