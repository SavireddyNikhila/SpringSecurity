package com.zkteco.springsecurity.service;

import java.util.List;

import com.zkteco.springsecurity.dto.Product;

public interface ProductService {

	List<Product> getProducts();

	Product getProduct(int id);

}
