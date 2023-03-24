package com.deloitte.inventorypricing.repository;

import com.deloitte.inventorypricing.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
