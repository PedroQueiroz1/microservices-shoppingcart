package com.shoppingcart.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< Updated upstream
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dto.ProductResponseDTO;
import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.service.ProductService;

/*
 * Bean Validation -> create
 */

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
	
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
	
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
		
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public ResponseEntity<ProductResponseDTO> update(@PathVariable("id") Long id,
			@Valid @RequestBody ProductRequestDTO productRequest){
		
		var productUpdate = productService.update(id, productRequest.convertToEntity());
		
		return ResponseEntity.ok(ProductResponseDTO.convertToProductResponseDTO(productUpdate)); 
		
	}	
	
	
	@DeleteMapping("/deleteById/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id) {
		productService.deleteById(id);
	}
	
	
	@DeleteMapping("/deleteByName/{name}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteByName(@PathVariable("name") String name) {
		productService.deleteByName(name);
	}
	
>>>>>>> Stashed changes
}
