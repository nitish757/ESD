package com.nitish.yummy.mapper;

import com.nitish.yummy.dto.CustomerRequest;
import com.nitish.yummy.dto.CustomerResponse;
import com.nitish.yummy.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        Customer customer = new Customer();
                customer.setFirstName(request.firstName());
                customer.setLastName(request.lastName());
                customer.setEmail(request.email());
                customer.setPassword(request.password());
                return customer;
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }
}
