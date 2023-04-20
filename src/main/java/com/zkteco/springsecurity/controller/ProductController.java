package com.zkteco.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.springsecurity.dto.Product;
import com.zkteco.springsecurity.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/all")
	public List<Product> getAllTheProducts(){
		return prodService.getProducts();
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return prodService.getProduct(id);
	}
}
