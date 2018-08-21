package com.service;

import com.entity.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class HelloController
 * function:
 *
 * @Author chens
 * @Date 2018/7/22
 */
@RestController
public class HelloController {

    @Autowired
    private ConfigBean configBean;

    @GetMapping("/hi")
    public String hi() {
        return "hello world" + configBean.getName() + configBean.getAge();
    }

}
