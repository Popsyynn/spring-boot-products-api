package com.example.springboottutorial.service;

import com.example.springboottutorial.entity.Product;

import java.util.Collection;

public interface ProductService {
    public abstract void createProduct(Product product);

    public abstract Collection<Product> getProduct();

    public abstract Product getUniqueProduct(Long id);

    public abstract void deleteProduct(Long id);

    public abstract void updateProduct(Long id , Product product);
}
