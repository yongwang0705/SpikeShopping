package com.wy.SpikeShopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpikeShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpikeShoppingApplication.class, args);
	}

}
