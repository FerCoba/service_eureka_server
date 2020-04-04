package com.springboot.microservice.microservices_item.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservice.microservices_item.dto.RestTemplateDto;
import com.springboot.microservice.microservices_item.entities.Item;
import com.springboot.microservice.microservices_item.entities.Product;
import com.springboot.microservice.microservices_item.response.ResponseRestTemplate;

@Service
public class ItemService {

	@Autowired
	RestTemplateDto restTemplateDto;
	
	public List<Item> obtainInformationAllItems() {

		List<ResponseRestTemplate> products = restTemplateDto.obtainInformationAllProducts();
		List<Product> productsList = products.listIterator().next().getProducts();

		for (Product product : productsList) {
			Product prod = new Product();
			prod.setId(product.getId());
			prod.setCrationDate(product.getCrationDate());
			prod.setPrice(product.getPrice());
			prod.setProductName(product.getProductName());
		}

		return productsList.stream().map(pr -> new Item(pr, 0)).collect(Collectors.toList());
	}

	public Item obtainInformationItemById(Long productId, Integer quantity) {
		ResponseRestTemplate product = restTemplateDto.obtainInformationByProductId(productId);
		return new Item(product.getProduct(), quantity);
	}

}
