package com.demo.productrates.service;

import com.demo.productrates.model.Product;
import com.demo.productrates.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
//@ConfigurationProperties(prefix = "inventory.pricing.http")
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${inventory.pricing.http.url}")
    private String url;

    public void saveProductDetails(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProductDetails() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProduct(int id) {
        return productRepository.findById(id).get();
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product Delete successfully";
    }

    public Product getProductRate(int productId) {
        Product product = new Product();
        ResponseEntity<Product> responseEntity = null;
        try {
            String httpUrl = url + productId;
            System.out.println("Http URl - "+httpUrl);
            //hht[headers]

            responseEntity = restTemplate.getForEntity(httpUrl, Product.class);

            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                product = responseEntity.getBody();
                System.out.println("Received the Product rate  - " + product.getPrice() + " for Id - " +product.getProductId());
                //save the product details
                productRepository.save(product);
                System.out.println("Product Details with rates saved in database");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return product;
    }
}