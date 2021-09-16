package com.tutoria.configmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigMserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigMserviceApplication.class, args);
	}

}
