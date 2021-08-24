package com.shoppingcart.app.dto;

import com.shoppingcart.app.entity.InventoryItem;

public class InventoryItemResponseDTO {

	private Long id;
	
	private ProductResponseDTO productResponse;
	
	private Integer quantity;

	//Maybe productResponse.get...
	public static InventoryItemResponseDTO convertToResponseDTO(InventoryItem inventoryItem) {
		return new InventoryItemResponseDTO(inventoryItem.getId(), inventoryItem.getQuantity());
	}

	
	public InventoryItemResponseDTO(Long id, Integer quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public InventoryItemResponseDTO() {
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductResponseDTO getProductResponse() {
		return productResponse;
	}

	public void setProductResponse(ProductResponseDTO productResponse) {
		this.productResponse = productResponse;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
