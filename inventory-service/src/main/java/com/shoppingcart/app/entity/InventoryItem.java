package com.shoppingcart.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
 * I won't use:
 * - HashCode and Equals
 * - NoArgsConstructor / AllArgsConstructor
 */

@Entity
@Table(name="inventory")
public class InventoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "product_id", nullable = false)
	@NotNull(message = "ProductId")
	private Long productId;
	
	@Column(name = "Quantity", nullable = false)
	@NotNull(message = "Quantity")
	@Min(value = 0, message = "Quantity")
	private Integer quantity;
	
	
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
