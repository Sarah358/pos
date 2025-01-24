package com.example.pos.controller;

import com.example.pos.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductsController {

    private static final List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 10),
            new Product(2, "SmartPhone", 20),
            new Product(3, "Screen", 30)
    );

    @GetMapping("/products")
    public List<Product> getProducts() {
        return products;
    }
}