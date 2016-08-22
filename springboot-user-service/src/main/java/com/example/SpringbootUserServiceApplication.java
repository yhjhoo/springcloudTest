package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableEurekaClient
@EnableAutoConfiguration
@SpringBootApplication
public class SpringbootUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootUserServiceApplication.class, args);
	}
	
}
