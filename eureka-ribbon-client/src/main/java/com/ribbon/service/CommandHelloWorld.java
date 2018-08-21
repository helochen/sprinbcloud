package com.ribbon.service;

import com.netflix.hystrix.HystrixCommand;

/**
 * class CommandHelloWorld
 * function:
 *
 * @Author chens
 * @Date 2018/8/7 21:52
 */
public class CommandHelloWorld extends HystrixCommand<String> {
    protected CommandHelloWorld(Setter setter) {
        super(setter);
    }

    @Override
    protected String run() throws Exception {
        return "test";
    }
}
