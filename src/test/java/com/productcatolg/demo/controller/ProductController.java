package com.productcatolg.demo.controller;


import com.productcatolg.demo.model.Product;
import com.productcatolg.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }
}