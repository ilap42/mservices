package com.tutoria.user.mservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //iNCLUIDO AL USAR EUREKA
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
