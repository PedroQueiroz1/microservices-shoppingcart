package com.shoppingcart.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.entity.InventoryItem;

/*
 * "findById" -> It's not necessary but I'll leave it here for study purpose
 */

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long>{

	public Optional<InventoryItem> findById(Long id);
	
	
}
