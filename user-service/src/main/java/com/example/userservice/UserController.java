package com.example.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class UserController
 * function:
 *
 * @Author chens
 * @Date 2018/8/19 15:28
 */
@RestController
@RequestMapping("/user")
public class UserController {


	@GetMapping("/hi")
	public String hi() {
		return "hi, im user-service";
	}
}
