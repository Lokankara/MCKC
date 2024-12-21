package com.mvc.commerce.dao;

import com.mvc.commerce.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

    @Query("select p from Product p where p.name like %:name%")
    List<Product> searchByName(String name);
}
