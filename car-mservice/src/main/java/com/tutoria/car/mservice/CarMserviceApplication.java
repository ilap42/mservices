package com.tutoria.car.mservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarMserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarMserviceApplication.class, args);
	}

}
