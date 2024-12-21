package com.mvc.commerce.service;

import com.mvc.commerce.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findBySearch(String name);
}
