package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * class BaseService
 * function:
 *
 * @Author chens
 * @Date 2018/11/7 22:45
 */
@Service
public class BaseService {

	@DBAspect
	public void testAop(String name , String age) {
		System.out.println(name + age);
		System.out.println("run..........");
	}
}
