package com.productcatolg.demo.service;

import com.productcatolg.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Laptop", 59999.0));
        products.add(new Product(2, "Phone", 29999.0));
        products.add(new Product(3, "Tablet", 19999.0));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> searchProductsByName(String keyword) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}