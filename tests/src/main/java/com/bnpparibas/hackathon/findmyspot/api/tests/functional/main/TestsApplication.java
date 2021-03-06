package com.bnpparibas.hackathon.findmyspot.api.tests.functional.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsApplication.class, args);
	}
	
	   @Bean
	    public RestTemplate getRestTemplate(){
	    	return new RestTemplate();
	    }

}
