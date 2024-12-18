package com.mvc.commence.service;

import com.mvc.commence.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findBySearch(String name);
}
