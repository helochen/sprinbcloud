package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * class BaseController
 * function:
 *
 * @Author chens
 * @Date 2018/11/7 22:43
 */
@Controller
@RequestMapping("/")
public class BaseController {


	@Autowired
	private BaseService baseService;

	@RequestMapping("/test")
	@ResponseBody
	public String testVoid() {

		baseService.testAop("fuck" , "320");
		System.out.println("run test void");

		return "fuck";
	}
}
