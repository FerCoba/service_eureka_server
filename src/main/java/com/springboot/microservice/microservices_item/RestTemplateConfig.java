package com.springboot.microservice.microservices_item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate clientRestTemplate() {
		return new RestTemplate();
	}
}
