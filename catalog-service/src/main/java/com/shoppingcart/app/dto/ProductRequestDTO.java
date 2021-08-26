package com.shoppingcart.app.dto;

import com.shoppingcart.app.entity.Product;

public class ProductRequestDTO {

	private String name;
	
	private String description;
	
	private Double price;
	
	public Product convertToEntity() {
		return new Product(name,description,price);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
		
}
