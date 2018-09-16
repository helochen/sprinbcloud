package com.example.userservice;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

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
	@ResponseBody
	public String hi() {
		return "hi, im user-service";
	}


	@GetMapping("/u")
	@ResponseBody
	public User getuser() {
		User user = new User();

		user.setId("aaa");
		user.setName("post");
		user.setValue(5);

		return user;
	}


	@GetMapping("/t")
	@ResponseBody
	public User getP(@RequestParam(name = "name", required = true) String name) {
		User user = new User();

		user.setId(name);
		user.setName(name);
		user.setValue(5);

		return user;
	}


	@PostMapping("/post")
	@ResponseBody
	public String testPost(@RequestBody(required = true) User user) {
		return JSONObject.toJSONString(user);
	}
}
