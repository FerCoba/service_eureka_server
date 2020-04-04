package com.springboot.microservice.microservices_item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservice.microservices_item.entities.Item;
import com.springboot.microservice.microservices_item.response.Response;
import com.springboot.microservice.microservices_item.services.ItemService;

@RestController
@RequestMapping(produces = "application/json")
public class ItemController {

	@Autowired
	ItemService itemSercice;

	@GetMapping("/obtainItemsInformation")
	public ResponseEntity<Response> obtainItemsInformation() {

		List<Item> itemsList = itemSercice.obtainInformationAllItems();

		return itemsList.isEmpty()
				? new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK.value()), "Not data Found", null, null),
						HttpStatus.OK)
				: new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK.value()), null, null, itemsList),
						HttpStatus.OK);
	}
	
	@GetMapping("id/{id}/quantity/{quantity}/obtainInformationItemById")
	public ResponseEntity<Response> obtainInformationItemById(@PathVariable Long id, @PathVariable Integer quantity) {

		Item item = itemSercice.obtainInformationItemById(id, quantity);

		return item == null
				? new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK.value()), "Not data Found", null, null),
						HttpStatus.OK)
				: new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK.value()), null, item, null),
						HttpStatus.OK);
	}
}
