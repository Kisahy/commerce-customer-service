package com.kisahy.commerce.customer.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kisahy.commerce.customer.dto.CustomerResponse;
import com.kisahy.commerce.customer.dto.SignUpRequest;
import com.kisahy.commerce.customer.entity.Customer;
import com.kisahy.commerce.customer.exception.DuplicateEmailException;
import com.kisahy.commerce.customer.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public CustomerResponse signUp(SignUpRequest request) {
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException("이미 사용 중인 이메일입니다.");
        }

        Customer customer = Customer.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .mobilePhone(request.getMobilePhone())
                .build();

        Customer saved = customerRepository.save(customer);

        return new CustomerResponse(saved);
    }
}
