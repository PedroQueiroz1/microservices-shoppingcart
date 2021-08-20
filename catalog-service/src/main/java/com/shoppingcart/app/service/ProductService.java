package com.shoppingcart.app.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository; 
	
	private Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	
	public Optional<Product> getById(Long id) {
		logger.info("Request to getById received!!! Id: "+id);
		
		return productRepository.findById(id);
	}
	
	//modificar para ver se existe? chegar no curso udemy
	public Product create(Product product) {
		
		return productRepository.save(product);
	}
	
	
	public void CheckIfItAlreadyExists(Product product) {
		Product productByName = productRepository.findByName(product.getName());
		if(productByName != null && productByName.getId() != product.getId()) {
			throw new RuntimeException(
			String.format("The product %s is already registered", product.getName().toUpperCase()));
		}
	}
}
