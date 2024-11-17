package com.nitish.yummy.controller;

import com.nitish.yummy.entity.Product;
import com.nitish.yummy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/top")
    public List<Product> getTopProducts(){
        List<Product> products = productService.getTopProducts();
        return products;
    }

    @GetMapping("/")
    public List<Product> getProducts(){
        List<Product> products = productService.getAllProducts();
        return products;
    }
}
