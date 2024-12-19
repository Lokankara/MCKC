package com.mvc.commence.dao;

import com.mvc.commence.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    @Query("select p from Product p where p.name like %:name%")
    List<User> searchByName(String name);
}
