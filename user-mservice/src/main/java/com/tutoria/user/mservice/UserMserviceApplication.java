package com.tutoria.user.mservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserMserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMserviceApplication.class, args);
	}

}
