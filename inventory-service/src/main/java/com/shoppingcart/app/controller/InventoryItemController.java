package com.shoppingcart.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dto.InventoryItemResponseDTO;
import com.shoppingcart.app.entity.InventoryItem;
import com.shoppingcart.app.service.InventoryItemService;

@RestController
@RequestMapping("/api/inventory-item")
public class InventoryItemController {

	@Autowired
	private InventoryItemService inventoryItemService;
	
	
	@GetMapping("/getById/{id}")
	@ResponseBody
	private ResponseEntity<InventoryItemResponseDTO> getById(@PathVariable("id") Long id){
		
		Optional<InventoryItem> inventoryItem = inventoryItemService.getById(id);
		
		return inventoryItem.isPresent()?ResponseEntity.ok(
				InventoryItemResponseDTO.convertToResponseDTO(inventoryItem.get())):
					ResponseEntity.notFound().build();
	}

	
}
