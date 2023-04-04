package com.demo.productrates.controller;

import com.demo.productrates.model.Product;
import com.demo.productrates.service.Message;
import com.demo.productrates.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    private Message message;

    @PostMapping(value = "/product/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveProduct(@RequestBody Product p) {
        System.out.println("Product details are : " + p.getProductId() + p.getProductName());
        productService.saveProductDetails(p);
        return "Product details saved to the database";
    }

    @GetMapping(value = "/product/getProductDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductDetails() {
        return productService.getProductDetails();
    }

    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productService.getProduct(id);
    }

    @DeleteMapping(value = "/product/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        return productService.deleteProduct(id);
    }

    @GetMapping(value = "/product/getProductRate/{id}")
    public ResponseEntity getProductRateDetails(@PathVariable("id") int productId) {
        Product p = productService.getProductRate(productId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping(value = "/product/getMessage")
    public String printMessage(){
        if(Objects.nonNull(message.getMessage())){
            return message.getMessage();
        }
         else return "Cannot read message from config properties";
    }
}
