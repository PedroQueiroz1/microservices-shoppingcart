package com.shoppingcart.app.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dto.ProductRequestDTO;
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
	
	@GetMapping("/getByName/{name}")
	@ResponseBody
	public ResponseEntity<ProductResponseDTO> getByName(@PathVariable("name") String name){
		Product product = productService.getByName(name);
		
		return ResponseEntity.ok(ProductResponseDTO
				.convertToProductResponseDTO(product));
	}
	
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<ProductResponseDTO> create(
			@Valid @RequestBody ProductRequestDTO productRequest){

		Product product = productService
				.createProduct(productRequest.convertToEntity());
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ProductResponseDTO.convertToProductResponseDTO(product));
	}
	
}
