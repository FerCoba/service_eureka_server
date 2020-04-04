package com.springboot.microservice.microservices_item.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.microservice.microservices_item.RestTemplateConfig;
import com.springboot.microservice.microservices_item.response.ResponseRestTemplate;

@Component
public class RestTemplateDto {

	@Autowired
	RestTemplateConfig restTemplateConfig;

	public List<ResponseRestTemplate> obtainInformationAllProducts() {
		List<ResponseRestTemplate> productsList = Arrays.asList(restTemplateConfig.clientRestTemplate()
				.getForObject("http://microservice-product/obtainInformationAllProducts", ResponseRestTemplate.class));
		productsList.removeIf(p -> p.getProducts().isEmpty());
		return productsList;
	}

	public ResponseRestTemplate obtainInformationByProductId(Long productId) {
		Map<String, String> param = new HashMap<>();
		param.put("productId", productId.toString());
		ResponseRestTemplate product = restTemplateConfig.clientRestTemplate()
				.getForObject("http://microservice-product/obtainProductInformation/{productId}", ResponseRestTemplate.class, param);		
		return product;
	}

}
