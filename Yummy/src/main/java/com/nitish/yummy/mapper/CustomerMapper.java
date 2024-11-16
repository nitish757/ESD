package com.nitish.yummy.mapper;

import com.nitish.yummy.dto.CustomerRequest;
import com.nitish.yummy.dto.CustomerResponse;
import com.nitish.yummy.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public Customer toCustomer(CustomerRequest request) {
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
    }
}
