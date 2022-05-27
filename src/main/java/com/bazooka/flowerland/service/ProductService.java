package com.bazooka.flowerland.service;

import com.bazooka.flowerland.entities.Product;
import com.bazooka.flowerland.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

@Service
@RequestScope
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> retrieveProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(p -> products.add(p));
        return products;
    }

    public Product findById(int id) { return productRepository.findById(id).orElse(null);};


}
