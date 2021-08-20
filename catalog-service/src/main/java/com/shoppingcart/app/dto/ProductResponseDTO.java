package com.shoppingcart.app.dto;

import com.shoppingcart.app.entity.Product;

public class ProductResponseDTO {

	private Long id;
	
	private String name;
	
	private String description;
	
	private Double price;

	public static ProductResponseDTO convertToProductResponseDTO(Product product) {
		return new ProductResponseDTO(product.getId(),product.getName(),product.getDescription(),
				product.getPrice());
	}

	public ProductResponseDTO(Long id, String name, String description, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
