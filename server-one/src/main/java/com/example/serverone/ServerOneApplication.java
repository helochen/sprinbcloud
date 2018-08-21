package com.example.serverone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class ServerOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerOneApplication.class, args);
	}
}
