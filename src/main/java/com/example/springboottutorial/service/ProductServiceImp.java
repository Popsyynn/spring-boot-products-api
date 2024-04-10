package com.example.springboottutorial.service;

import com.example.springboottutorial.entity.Product;
import com.example.springboottutorial.error.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImp implements ProductService {

    private static Map<Long, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId(1L);
        honey.setName("Swiss");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId(2l);
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }


    @Override
    public void createProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    @Override
    public Collection<Product> getProduct() {
        List<Product> products = new ArrayList<>(productRepo.values());
        return products;
    }

    @Override
    public Product getUniqueProduct(Long id) {
        return productRepo.get(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.remove(id);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        if (!productRepo.containsKey(id)) throw
            new ProductNotFoundException();
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }
}
