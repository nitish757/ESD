package com.nitish.yummy.services;

import com.nitish.yummy.entity.Product;
import com.nitish.yummy.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    public List<Product> getTopProducts() {
        return productRepo.findTopProducts(15,30,2);
    }


    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
