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
	
	
<<<<<<< HEAD
=======
	public void CheckIfItAlreadyExists(Product createdProduct) {
		Optional<Product> product = productRepository.findByName(createdProduct.getName());
		Product productByName = product.get();
		if(productByName != null && productByName.getId() != createdProduct.getId()) {
			throw new RuntimeException(
			String.format("The product %s is already registered", createdProduct.getName().toUpperCase()));
<<<<<<< HEAD
=======
	public Product update(Long id, Product product) {
		
		logger.info("Request to 'update' received!!! Product_Id: "+id);
		
		Product productToModifie = checkIfExists(id);
		
		validateDuplicatedProduct(product);
		BeanUtils.copyProperties(product, productToModifie, "id");
		
		return productRepository.save(productToModifie);
		
	}
	
	
	public void deleteById(Long id) {
		logger.info("Request to 'deleteById' received!!! Product_Id: "+id);
		
		productRepository.deleteById(id);
	}
	
	public void deleteByName(String name) {
		logger.info("Request to 'deleteByName' received!!! Product_name: "+name);
		
		productRepository.deleteByName(name);
	}
	
	
	public Product update(Long id, Product product) {
		
		logger.info("Request to 'update' received!!! Product_Id: "+id);
		
		Product productToModifie = checkIfExists(id);
		
		validateDuplicatedProduct(product);
		BeanUtils.copyProperties(product, productToModifie, "id");
		
		return productRepository.save(productToModifie);
		
	}
	
	
	public void deleteById(Long id) {
		logger.info("Request to 'deleteById' received!!! Product_Id: "+id);
		
		productRepository.deleteById(id);
	}
	
	public void deleteByName(String name) {
		logger.info("Request to 'deleteByName' received!!! Product_name: "+name);
		
		productRepository.deleteByName(name);
	}
	
	
	public Product update(Long id, Product product) {
		
		logger.info("Request to 'update' received!!! Product_Id: "+id);
		
		Product productToModifie = checkIfExists(id);
		
		validateDuplicatedProduct(product);
		BeanUtils.copyProperties(product, productToModifie, "id");
		
		return productRepository.save(productToModifie);
		
	}
	
	
	public void deleteById(Long id) {
		logger.info("Request to 'deleteById' received!!! Product_Id: "+id);
		
		productRepository.deleteById(id);
	}
	
	public void deleteByName(String name) {
		logger.info("Request to 'deleteByName' received!!! Product_name: "+name);
		
		productRepository.deleteByName(name);
	}
	
	
>>>>>>> develop
	private void validateDuplicatedProduct(Product product) {
		
		Product productFind = productRepository.findByName(product.getName());
		
		if(productFind != null && productFind.getId() != product.getId()) {
			throw new BusinessRuleException(String.format("The following product is"
					+ " already registered: %s.", product.getName().toUpperCase())); 
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
=======
>>>>>>> parent of 01093de... Modifying index file and adding css
>>>>>>> develop
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
