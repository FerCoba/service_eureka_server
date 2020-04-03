package com.springboot.microservice.microservices_item.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservice.microservices_item.dto.RestTemplateDto;
import com.springboot.microservice.microservices_item.entities.Item;
import com.springboot.microservice.microservices_item.entities.Product;

@Service
public class ItemService {

	@Autowired
	RestTemplateDto restTemplateDto;

	public List<Item> obtainInformationAllItems() {
		List<Product> products = restTemplateDto.obtainInformationAllProducts();
		return products.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
	}

	public Item obtainInformationItemById(Long productId, Integer quantity) {
		Product product = restTemplateDto.obtainInformationByProductId(productId);

		return new Item(product, quantity);
	}
}
