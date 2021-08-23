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
		logger.info("Request to 'getById' received!!! Id: "+id);
		
		return productRepository.findById(id);
	}
	
	
	public Optional<Product> getByName(String name){
		logger.info("Request to 'getByName' received!!! Name: "+name);
		
		return productRepository.findByName(name.trim().toUpperCase());
	}
	
	
	public Product createProduct(Product product) {
		logger.info("Request to 'createProduct' received!!! Product_Id: "
	+product.getId() + " Product_Name: "+product.getName());
		CheckIfItAlreadyExists(product);
		return productRepository.save(product);
	}
	
	
	public void CheckIfItAlreadyExists(Product createdProduct) {
		Optional<Product> product = productRepository.findByName(createdProduct.getName());
		Product productByName = product.get();
		if(productByName != null && productByName.getId() != createdProduct.getId()) {
			throw new RuntimeException(
			String.format("The product %s is already registered", createdProduct.getName().toUpperCase()));
		}
	}
}
