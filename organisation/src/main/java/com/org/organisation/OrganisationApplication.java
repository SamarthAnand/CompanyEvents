package com.org.organisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class OrganisationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganisationApplication.class, args);
	}

}
