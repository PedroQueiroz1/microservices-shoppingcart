package com.shoppingcart.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dto.ProductResponseDTO;
import com.shoppingcart.app.feignclients.CatalogFeignClient;

@Service
public class CommonService {

	Logger logger = LoggerFactory.getLogger(CommonService.class);
	
	private Long count = 1L;
	
	@Autowired
	CatalogFeignClient catalogFeignClient;
	
	public ProductResponseDTO getProductById(Long productId) {
		logger.info("count = " +count);
		count++;
		ProductResponseDTO productResponse = 
				catalogFeignClient.getById(productId);
		return productResponse;
	}
	
	public ProductResponseDTO fallbackAddressById(Long productId, Throwable th) {
		logger.error("Error = " +th);
		return new ProductResponseDTO();
	}
}
