package com.mvc.commence.service;

import com.mvc.commence.dao.ProductDao;
import com.mvc.commence.model.Product;
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
