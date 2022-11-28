package com.example.servidorGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServidorGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorGatewayApplication.class, args);
	}

}
