package com.example.ribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * class RestController
 * function:
 *
 * @Author chens
 * @Date 2018/7/30
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/testRibbon")
    public String testRibbon() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("stores");
        return serviceInstance.getHost() + serviceInstance.getPort();
    }
}
