package com.zkteco.springsecurity.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.zkteco.springsecurity.dto.Product;
import com.zkteco.springsecurity.service.ProductService;

import jakarta.annotation.PostConstruct;

@Service
public class ProductServiceImpl implements ProductService{

	List<Product> productList = null;
	
	@PostConstruct
	public void loadProductsFromDB() {
		productList = IntStream.rangeClosed(1, 100)
				.mapToObj(i->Product.builder()
						.id(i)
						.name("product"+i)
						.qty(new Random().nextInt(10))
						.price(new Random().nextInt(5000)).build()
						).collect(Collectors.toList());
	}
	
	@Override
	public List<Product> getProducts() {
		return productList;
	}
	
	public Product getProduct(int id) {
		return productList.stream()
				.filter(product -> product.getId() == id)
				.findAny()
				.orElseThrow(() -> new RuntimeException("product "+id+" not found"));
	}

}
