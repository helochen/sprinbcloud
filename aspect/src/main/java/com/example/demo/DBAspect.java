package com.example.demo;

import java.lang.annotation.*;

/**
 * Annotation DBAspect
 * function:
 *
 * @Author chens
 * @Date 2018/11/7 22:48
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DBAspect {
}
