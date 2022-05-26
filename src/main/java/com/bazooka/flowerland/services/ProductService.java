package com.bazooka.flowerland.services;

import com.bazooka.flowerland.entities.Product;
import com.bazooka.flowerland.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> retrieveProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(resident -> products.add(resident));
        return products;
    }

    public Product findById(int id) { return productRepository.findById(id).orElse(null);};


}
