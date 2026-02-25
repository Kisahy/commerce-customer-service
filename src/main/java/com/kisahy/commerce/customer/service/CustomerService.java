package com.kisahy.commerce.customer.service;

import com.kisahy.commerce.customer.dto.CustomerResponse;
import com.kisahy.commerce.customer.dto.SignUpRequest;

public interface CustomerService {
    CustomerResponse signUp(SignUpRequest signUpRequest);
}
