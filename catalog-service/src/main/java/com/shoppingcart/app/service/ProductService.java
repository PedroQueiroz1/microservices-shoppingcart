package com.shoppingcart.app.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.exception.BusinessRuleException;
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
	
	
	public Product getByName(String name){
		logger.info("Request to 'getByName' received!!! Name: "+name);
		
		return productRepository.findByName(name.trim().toUpperCase());
	}
	
	
	public Product createProduct(Product product) {
		
		logger.info("Request to 'createProduct' received!!! Product_Id: "
	+product.getId() + " Product_Name: "+product.getName());
		
		validateDuplicatedProduct(product); 
		
		return productRepository.save(product);
	}
	
	
	
	
	private void validateDuplicatedProduct(Product product) {
		
		Product productFind = productRepository.findByName(product.getName());
		
		if(productFind != null && productFind.getId() != product.getId()) {
			throw new BusinessRuleException(String.format("The following product is"
					+ " already registered: %s.", product.getName().toUpperCase())); 
		}
	}
	
	
	private Product checkIfExists(Long id) {
		Optional<Product> product = getById(id);
		if(product.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return product.get();
	}
	

}
