package com.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AirportService {

	public static void main(String[] args) {
		SpringApplication.run(AirportService.class, args);
	}

}
