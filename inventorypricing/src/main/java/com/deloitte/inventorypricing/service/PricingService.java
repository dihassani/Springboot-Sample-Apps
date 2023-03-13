package com.deloitte.inventorypricing.service;

import com.deloitte.inventorypricing.model.Product;
import com.deloitte.inventorypricing.model.request.PricingRequest;
import com.deloitte.inventorypricing.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class PricingService {

    @Autowired
    private ProductRepository productRepository;

    public Product retrievePriceById(int productId ) {
        log.info("Pricing Service ::: Retrieve Product Price for product id {}", productId);
        return this.productRepository.findById(productId).get();
    }

    public List<Product> retrieveAllProducts(){
        log.info("Pricing Service ::: Retrieve All Products");
        return (List<Product>) productRepository.findAll();
    }

    public Product addProduct(Product product){
        log.info("Pricing Service ::: Add Product Request");
        if(product.getBarcode().isEmpty()){
            Random random = new Random();
            StringBuilder randomBarcode = new StringBuilder();
            randomBarcode.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                randomBarcode.append(random.nextInt(10));
            }
            product.setBarcode(randomBarcode.toString());
        }
        return this.productRepository.save(product);
    }

    public void deleteProduct(int id) {
        this.productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        this.productRepository.deleteAll();
    }
}
