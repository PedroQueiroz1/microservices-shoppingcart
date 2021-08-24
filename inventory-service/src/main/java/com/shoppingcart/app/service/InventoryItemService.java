package com.shoppingcart.app.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dto.InventoryItemResponseDTO;
import com.shoppingcart.app.entity.InventoryItem;
import com.shoppingcart.app.repository.InventoryItemRepository;

@Service
public class InventoryItemService {

	@Autowired
	private InventoryItemRepository inventoryItemRepository;
	
	Logger logger = LoggerFactory.getLogger(InventoryItemService.class);
	
	@Autowired
	private CommonService commonService;
	
	
	public InventoryItemResponseDTO getById(Long id){
	
		logger.info("Request to 'getById' received!!! Id: "+id);
		
		Optional<InventoryItem> inventory = inventoryItemRepository.findById(id);
		InventoryItemResponseDTO inventoryResponse = InventoryItemResponseDTO.convertToResponseDTO(inventory.get());
		
		inventoryResponse.setProductResponse(commonService.getProductById(inventory.get().getId()));
		
		return inventoryResponse;
	}
	
}
