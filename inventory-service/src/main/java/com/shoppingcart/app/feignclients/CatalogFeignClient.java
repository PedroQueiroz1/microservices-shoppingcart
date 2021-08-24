package com.shoppingcart.app.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shoppingcart.app.dto.ProductResponseDTO;

@FeignClient(value = "api-gateway")
public interface CatalogFeignClient {
	
	@GetMapping("catalog-service/api/catalog/getById/{id}")
	public ProductResponseDTO getById(@PathVariable Long id);
	


}
