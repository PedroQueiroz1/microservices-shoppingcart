package com.shoppingcart.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.shoppingcart.app.dto.InventoryItemResponseDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryItemServiceTest {

	
	@Autowired
	private InventoryItemService inventoryItemService;
	
	@Test
	public void getById1() {
		InventoryItemResponseDTO inventory = inventoryItemService.getById(1L);
		assertTrue(inventory.getQuantity()==10);
		assertTrue(inventory.getId()==1L);
	}
	
	@Test
	public void getByProductId() {
		InventoryItemResponseDTO inventory = inventoryItemService.getById(2L);
		assertEquals(inventory.getId(), inventory.getProductResponse().getId());
	}
	
	@Test 
	public void getById() {
		InventoryItemResponseDTO inventory = inventoryItemService.getById(3L);
		assertTrue(inventory.getId()==3L);
	}
	
}
