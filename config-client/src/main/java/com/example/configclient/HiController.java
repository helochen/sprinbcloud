package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class HiController
 * function:
 *
 * @Author chens
 * @Date 2018/8/13 22:29
 */
@RestController
public class HiController {

	@Value("${foo}")
	private String foo;

	@RequestMapping(value = "/foo")
	public String hi() {
		return foo;
	}
}
