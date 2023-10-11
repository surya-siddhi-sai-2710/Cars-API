package com.dh.rest.api.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dh.*")
public class CarsAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsAPIApplication.class, args);
	}
}