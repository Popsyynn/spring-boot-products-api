package com.example.springboottutorial.controller;

import com.example.springboottutorial.entity.Product;
import com.example.springboottutorial.service.ProductService;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class LoggingController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody @Valid Product product){
    productService.createProduct(product);
    return new ResponseEntity<>("Product is created successfully" , HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = new ArrayList<>(productService.getProduct());
        return new ResponseEntity<>(products , HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Object> getUniqueProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.getUniqueProduct(id) , HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProducts(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("product is deleted successfully" , HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProducts(@PathVariable Long id , @RequestBody Product product){
        productService.updateProduct(id, product);
        return new ResponseEntity<>("product is updated successfully", HttpStatus.OK);
    }

}

