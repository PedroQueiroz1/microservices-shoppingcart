package com.shoppingcart.app.dto;

import com.shoppingcart.app.entity.InventoryItem;

public class InventoryItemResponseDTO {

	private Long id;
	
	private Long productId;
	
	private Integer quantity;

	public static InventoryItemResponseDTO convertToResponseDTO(InventoryItem inventoryItem) {
		return new InventoryItemResponseDTO(inventoryItem.getId(),
				inventoryItem.getProductId(), inventoryItem.getQuantity());
	}
	
	
	public InventoryItemResponseDTO(Long id, Long productId, Integer quantity) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
