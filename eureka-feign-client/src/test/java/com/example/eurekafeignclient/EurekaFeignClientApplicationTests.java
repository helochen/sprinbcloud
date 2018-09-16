package com.example.eurekafeignclient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class EurekaFeignClientApplicationTests {


	@Autowired
	private HiServer hiServer;

	@MockBean
	private HiHystrix hiHystrix;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setEurekaClientFeign() {
		System.out.println("begin......................");
	}

	@Test
	public void testRemoteService() {

		String name = "test";

		given(this.hiHystrix.sayHiFeignClientEureka(name)).willReturn("hi,test");

		String hi_return = hiServer.sayHi(name);


		assertThat(hi_return.equals("hi,test"));

	}
}
