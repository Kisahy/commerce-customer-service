package com.kisahy.commerce.customer.dto;

import java.time.LocalDateTime;

import com.kisahy.commerce.customer.entity.Customer;
import com.kisahy.commerce.customer.enums.CustomerStatus;

public class CustomerResponse {
    private final Long id;
    private final String email;
    private final String name;
    private final String mobilePhone;
    private final CustomerStatus status;
    private final LocalDateTime createdAt;

    private CustomerResponse(
            Long id,
            String email,
            String name,
            String mobilePhone,
            CustomerStatus status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.status = status;
        this.createdAt = createdAt;
    }

    public static CustomerResponse from(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getEmail(),
                customer.getName(),
                customer.getMobilePhone(),
                customer.getStatus(),
                customer.getCreatedAt()
        );
    }
    
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
