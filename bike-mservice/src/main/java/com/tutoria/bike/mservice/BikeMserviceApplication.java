package com.tutoria.bike.mservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BikeMserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeMserviceApplication.class, args);
	}

}
