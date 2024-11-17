package com.nitish.yummy.helper;

import com.nitish.yummy.entity.Customer;
import com.nitish.yummy.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer user = repo.findByEmail(username);
        if(user == null) {
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User Not found");
        }

        return new UserPrincipal(user);
    }
}
