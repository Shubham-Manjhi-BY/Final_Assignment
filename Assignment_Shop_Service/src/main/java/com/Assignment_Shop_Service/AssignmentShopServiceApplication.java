package com.Assignment_Shop_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//@EnableEurekaClient
@SpringBootApplication
public class AssignmentShopServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentShopServiceApplication.class, args);
	}

}
