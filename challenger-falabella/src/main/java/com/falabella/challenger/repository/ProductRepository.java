package com.falabella.challenger.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.falabella.challenger.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
    List<Product> findByName(String name);
    
}
