package com.sapient.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Developer: Aviral Srivastava
 * Date: 13, May, 2020
 * Following features have been implemented: 
 * 1. Spring-boot framework is used.
   2. DB has been mocked with H2 database which is provided by Spring-boot as out of the box feature.
   3. JUnit and Integration level test cases have been implemented.
   4. Postman collection has been uploaded to github under folder - postman_collection.
   5. In code , current profile is activated as "application-dev". Its configurable from application.properties.
 * 
 * *
 */



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
