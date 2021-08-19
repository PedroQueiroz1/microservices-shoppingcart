package com.shoppingcart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
