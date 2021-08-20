package com.shoppingcart.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.entity.Product;

/*
 * "findById" -> It's not necessary but I'll leave it here for study purpose
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	public Optional<Product> findById(Long id);
	
	public Product findByName(String name);
	
}