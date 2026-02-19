package com.external_api_intigration.External.API.Integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ExternalApiIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalApiIntegrationApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate (){
		return new RestTemplate();
	}


}
