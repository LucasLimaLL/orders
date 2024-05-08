package com.techchallange.orders.configurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.techchallange.orders")
@EnableJpaRepositories(basePackages = "com.techchallange.orders.adapters.persistence.repositories")
@EntityScan(basePackages = "com.techchallange.orders.adapters.persistence.entities")
public class OrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}

}
