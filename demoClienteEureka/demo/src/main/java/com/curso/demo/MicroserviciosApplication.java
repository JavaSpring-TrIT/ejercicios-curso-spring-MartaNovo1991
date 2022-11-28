package com.curso.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.curso.controller","com.curso.service","com.curso.demo"})
@EnableEurekaClient
public class MicroserviciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		BasicAuthenticationInterceptor interceptor;
		interceptor = new BasicAuthenticationInterceptor("user3","user3");
		RestTemplate template = new RestTemplate();
		template.getInterceptors().add(interceptor);
		return new RestTemplate() ;
	}

}
