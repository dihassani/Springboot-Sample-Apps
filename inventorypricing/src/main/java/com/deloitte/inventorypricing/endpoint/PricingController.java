package com.deloitte.inventorypricing.endpoint;

import com.deloitte.inventorypricing.model.Product;
import com.deloitte.inventorypricing.service.PricingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @GetMapping(value = "/pricing/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getProductPrice(@PathVariable("id") int productId) {
        log.info("Pricing Controller ::: Received Product Pricing Request - {}", productId);
        try{
            Product response = this.pricingService.retrievePriceById(productId);
            if(response != null){
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Pricing Controller ::: Something went wrong while retrieving pricing - {}", e.getMessage());
            return new ResponseEntity<>("Error Occurred / Not Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/pricing/getProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getAllProductPrices() {
        log.info("Pricing Controller ::: Received Request to retrieve all Products");
        try{
            List<Product> products = this.pricingService.retrieveAllProducts();
            if(products != null){
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Pricing Controller ::: Something went wrong while retrieving pricing - {}", e.getMessage());
            return new ResponseEntity<>("Error Occurred / Not Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/pricing/add", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus addProductPricing(@RequestBody Product addProductRequest){
        log.info("Pricing Controller ::: Received Product to Add - {}", addProductRequest);
        if(addProductRequest.getProductId() == null){
            return HttpStatus.BAD_REQUEST;
        }

        try{
            Product response = this.pricingService.addProduct(addProductRequest);
            if(response != null){
                return HttpStatus.CREATED;
            }
        } catch (Exception e){
            log.error("Pricing Controller ::: Something went wrong while saving new Product - {}", e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @DeleteMapping(value = "/pricing/{id}")
    public HttpStatus deleteProduct(@PathVariable("id") int productId){
        try{
            this.pricingService.deleteProduct(productId);
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "/pricing/delete")
    public HttpStatus deleteAllProducts(){
        try{
            this.pricingService.deleteAllProducts();
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.OK;
    }
}
