package com.springboot.microservice.microservices_item.entities;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private Long id;
	private String productName;
	private Date crationDate;
	private BigDecimal price;
	private Integer port;
}
