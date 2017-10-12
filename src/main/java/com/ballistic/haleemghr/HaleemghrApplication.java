package com.ballistic.haleemghr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan(basePackages = "com.ballistic.haleemghr")
public class HaleemghrApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HaleemghrApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HaleemghrApplication.class, args);
	}
}
