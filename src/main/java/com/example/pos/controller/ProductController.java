package com.example.pos.controller;


import com.example.pos.entity.Product;
import com.example.pos.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;


    @GetMapping("/findAll")
    public List<Product> getProduct (){

        return   productRepo.findAll();
    }

    @PostMapping("/insert")
    public Product insertProduct (@RequestBody Product product){

        return   productRepo.save(product);
    }
}