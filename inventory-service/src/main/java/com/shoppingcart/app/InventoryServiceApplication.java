package com.shoppingcart.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.shoppingcart.app.repository")
@EntityScan("com.shoppingcart.app.entity")
@ComponentScan({"com.shoppingcart.app.controller","com.shoppingcart.app.service"})
@EnableFeignClients("com.shoppingcart.app.feignclients")
@EnableEurekaClient
public class InventoryServiceApplication {

	@Value("${catalog.service.url}")
	private String catalogServiceUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	
}
