package com.mvc.commerce.service;

import com.mvc.commerce.dao.ProductDao;
import com.mvc.commerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    private final ProductDao productDao;

    public DefaultProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findBySearch(String name) {
        return productDao.searchByName(name);
    }

}
