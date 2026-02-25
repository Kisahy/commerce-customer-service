package com.kisahy.commerce.customer.controller.store;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kisahy.commerce.customer.dto.CustomerResponse;
import com.kisahy.commerce.customer.dto.SignUpRequest;
import com.kisahy.commerce.customer.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/store/customers")
public class StoreCustomerController {
    private final CustomerService customerservice;

    public StoreCustomerController(CustomerService customerservice) {
        this.customerservice = customerservice;
    }

    @PostMapping("sign-up")
    public ResponseEntity<CustomerResponse> signUp(
            @RequestBody @Valid SignUpRequest request
    ) {
        CustomerResponse response = customerservice.signUp(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
