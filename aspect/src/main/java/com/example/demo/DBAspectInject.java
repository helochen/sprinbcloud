package com.example.demo;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * class DBAspectInject
 * function:
 *
 * @Author chens
 * @Date 2018/11/7 22:50
 */
@Aspect
@Component
public class DBAspectInject {

	@Before("@annotation(dbAspect)")
	public void beforeDemo(JoinPoint point, DBAspect dbAspect) {
		System.out.println("before.....");
	}

	@Around("@annotation(dbAspect)")
	public void aroundDemo(ProceedingJoinPoint joinPoint , DBAspect dbAspect) {
		System.out.println("start");

		try {
			joinPoint.proceed(joinPoint.getArgs());
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		System.out.println("end");
	}
}
