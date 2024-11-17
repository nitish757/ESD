package com.nitish.yummy.services;

import com.nitish.yummy.dto.CustomerRequest;
import com.nitish.yummy.dto.CustomerResponse;
import com.nitish.yummy.dto.LoginRequest;
import com.nitish.yummy.entity.Customer;
import com.nitish.yummy.exception.CustomerNotFoundException;
import com.nitish.yummy.helper.JWTService;
import com.nitish.yummy.mapper.CustomerMapper;
import com.nitish.yummy.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    private final CustomerRepo customerRepo;
    @Autowired
    private final CustomerMapper customerMapper;
    @Autowired
    private final JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public CustomerResponse createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customer.setPassword(encoder.encode(customer.getPassword()));
        return customerMapper.toCustomerResponse(customerRepo.save(customer));
    }

//    public Customer getCustomer(String email) {
//        return customerRepo.findByEmail(email)
//                .orElseThrow(() -> new CustomerNotFoundException(
//                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
//                ));
//    }

//    public CustomerResponse retrieveCustomer(String email) {
//        Customer customer = getCustomer(email);
//        return customerMapper.toCustomerResponse(customer);
//    }

    public String login(LoginRequest request) {
        Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(request.email());

        return "Fail";
    }
}