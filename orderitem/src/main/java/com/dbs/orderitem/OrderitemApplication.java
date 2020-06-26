package com.dbs.orderitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderitemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderitemApplication.class, args);
	}

}
