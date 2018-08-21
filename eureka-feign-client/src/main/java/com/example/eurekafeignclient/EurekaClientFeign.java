package com.example.eurekafeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * interface EurekaClientFeign
 * function:
 *
 * @Author chens
 * @Date 2018/8/1
 */
@FeignClient(value = "eureka-client" , configuration = FeignConfig.class, fallback = HiHystrix.class)
public interface EurekaClientFeign {


    @GetMapping(value = "/hi")
    String sayHiFeignClientEureka(@RequestParam(value = "name") String name);

    @GetMapping(value = "/hello")
    String sayHelloFeignClientEureka(@RequestParam(value = "hello") String hello);
}
