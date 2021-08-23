package com.shoppingcart.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableFeignClients("com.shoppingcart.app.feignclients")

@SpringBootApplication
@EnableJpaRepositories("com.shoppingcart.app.repository")
@EntityScan("com.shoppingcart.app.entity")
@ComponentScan({"com.shoppingcart.app.controller","com.shoppingcart.app.service"})
@EnableEurekaClient
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

}
