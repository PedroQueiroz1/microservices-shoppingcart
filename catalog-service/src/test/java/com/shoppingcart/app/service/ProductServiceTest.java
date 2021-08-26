package com.shoppingcart.app.service;

import static org.hamcrest.CoreMatchers.startsWith;

import java.util.Optional;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.shoppingcart.app.entity.Product;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {

	
	@Autowired
	private ProductService productService;
	
	@Test
	public void getById() {
		Optional<Product> product = productService.getById(1L);
		Assert.assertEquals("Estojo",product.get().getName());
		Assert.assertTrue(product.get().getName().startsWith("Es"));
	}
	
}
