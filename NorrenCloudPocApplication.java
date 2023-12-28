package com.NorrenCloud.CloudPoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class NorrenCloudPocApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NorrenCloudPocApplication.class, args);
	}
	
	
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NorrenCloudPocApplication.class);	
		
	}
}
