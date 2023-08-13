package com.mra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingMgmtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingMgmtServiceApplication.class, args);
	}

}
