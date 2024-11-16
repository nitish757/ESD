package com.nitish.yummy.repo;

import com.nitish.yummy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByEmail(String email);

}
