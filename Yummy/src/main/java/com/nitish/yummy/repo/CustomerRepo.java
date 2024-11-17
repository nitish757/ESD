package com.nitish.yummy.repo;

import com.nitish.yummy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    //Optional<Customer> findByEmail(String email);

    Customer findByEmail(String email);
}
