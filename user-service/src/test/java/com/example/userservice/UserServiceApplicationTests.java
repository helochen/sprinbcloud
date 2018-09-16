package com.example.userservice;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {


	}


	@Test
	public void testMvc()  {
		try {
			this.mvc.perform(get("/user/hi")).andExpect(status().isOk())
					.andExpect(content().string("hi, im user-service"));//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testUserObj() {
		try {

			User user = new User();
			user.setValue(5);
			user.setId("aaa");
			user.setName("post");

			String str = JSONObject.toJSONString(user);

			this.mvc.perform(get("/user/u")).andExpect(status().isOk())
					.andExpect(content().json(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testParams() {

		String name = "test";
		User user = new User();

		user.setId(name);
		user.setName(name);
		user.setValue(5);

		String json = JSONObject.toJSONString(user);
		try {
			this.mvc.perform(get("/user/t").param("name" , name)).andExpect(status().isOk())
					.andExpect(content().json(json));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void testPost() {
		User user = new User();
		user.setValue(123);
		user.setName("123");
		user.setId("1");

		User target = new User();

		BeanUtils.copyProperties(user , target);

		//target.setId("2");
		try {
			this.mvc.perform(post("/user/post").contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(JSONObject.toJSONString(user))).andExpect(status().isOk()).andExpect(
					content().json(JSONObject.toJSONString(target))
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
