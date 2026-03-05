package com.kisahy.commerce.customer.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kisahy.commerce.customer.dto.LoginRequest;
import com.kisahy.commerce.customer.dto.LoginResponse;
import com.kisahy.commerce.customer.jwt.JwtProvider;
import com.kisahy.commerce.customer.repository.CustomerRepository;

@Service
public class StoreAuthService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public StoreAuthService(
            CustomerRepository customerRepository,
            PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider
    ) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public LoginResponse login(LoginRequest request) {
        var customer = customerRepository.findByEmail(request.getEmail()).orElseThrow(() ->
                new IllegalArgumentException("Invalid email address provided")
        );

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new IllegalArgumentException("Invalid password provided");
        }

        String token = jwtProvider.generateToken(customer.getId(), customer.getEmail());

        return new LoginResponse(token);
    }

}
