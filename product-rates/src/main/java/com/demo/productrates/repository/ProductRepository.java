package com.demo.productrates.repository;

import com.demo.productrates.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
