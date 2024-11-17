package com.nitish.yummy.controller;

import com.nitish.yummy.dto.CustomerRequest;
import com.nitish.yummy.dto.CustomerResponse;
import com.nitish.yummy.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/v1/customer")

public class CustomerController {
    public final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
}
