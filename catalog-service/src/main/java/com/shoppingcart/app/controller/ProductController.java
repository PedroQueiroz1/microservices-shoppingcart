package com.shoppingcart.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dto.ProductResponseDTO;
import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.service.ProductService;

@RestController
@RequestMapping("/api/catalog")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/getById/{id}")
	@ResponseBody
	public ResponseEntity<ProductResponseDTO> getById(@PathVariable("id") Long id) {
		Optional<Product> product = productService.getById(id); 
		return product.isPresent()?ResponseEntity
				.ok(ProductResponseDTO.convertToProductResponseDTO(product.get()))
						:ResponseEntity.notFound().build();
	}
	
}
