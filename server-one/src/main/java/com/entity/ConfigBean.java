package com.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * class ConfigBean
 * function:
 *
 * @Author chens
 * @Date 2018/7/22
 */
@ConfigurationProperties(prefix = "my")
@Component
public class ConfigBean {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
