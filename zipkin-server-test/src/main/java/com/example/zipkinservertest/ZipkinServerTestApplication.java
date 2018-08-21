package com.example.zipkinservertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerTestApplication.class, args);
	}
}
