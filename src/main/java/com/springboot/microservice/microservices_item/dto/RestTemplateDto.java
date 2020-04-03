package com.springboot.microservice.microservices_item.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.microservice.microservices_item.RestTemplateConfig;
import com.springboot.microservice.microservices_item.entities.Product;

@Component
public class RestTemplateDto {

	@Autowired
	RestTemplateConfig restTemplateConfig;

	public List<Product> obtainInformationAllProducts() {
		List<Product> productsList = Arrays.asList(restTemplateConfig.clientRestTemplate()
				.getForObject("http://localhost:8001/obtainInformationAllProducts", Product.class));
		return productsList;
	}

	public Product obtainInformationByProductId(Long productId) {
		Map<String, String> param = new HashMap<>();
		param.put("productId", productId.toString());
		Product product = restTemplateConfig.clientRestTemplate()
				.getForObject("http://localhost:8001/obtainProductInformation/{productId}", Product.class, param);

		return product;
	}

}
