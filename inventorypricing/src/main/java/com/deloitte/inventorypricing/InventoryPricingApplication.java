package com.deloitte.inventorypricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InventoryPricingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryPricingApplication.class, args);
	}

}
