package com.javaweb.trapham.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.javaweb")
public class HellospringApplication {
	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}
}
