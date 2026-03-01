package com.kisahy.commerce.customer.service;

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

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public CustomerResponse signUp(SignUpRequest request) {
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException("이미 사용 중인 이메일입니다.");
        }

        Customer customer = Customer.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .mobilePhone(request.getMobilePhone())
                .build();

        Customer saved = customerRepository.save(customer);

        return new CustomerResponse(saved);
    }
}
