package com.ribbon.controller;

import com.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * class RibbonController
 * function:
 *
 * @Author chens
 * @Date 2018/7/28
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("hi")
    public String hi(@RequestParam(required = false, name = "name", defaultValue = "chen") String name) {
        return ribbonService.sayHi(name);
    }

    @GetMapping("testRibbon")
    public String testRibbon() {
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        return instance.getHost() + ":" + instance.getPort();
    }
}
