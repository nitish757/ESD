package com.nitish.yummy.repo;

import com.nitish.yummy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


    @Query("SELECT p from Product p where p.price between :i1 AND :i2 order by p.price asc limit :i3")
    List<Product> findTopProducts(int i1, int i2, int i3);
    // Product findByEmail(String email);

}
