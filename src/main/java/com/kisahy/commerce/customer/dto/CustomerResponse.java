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

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.email = customer.getEmail();
        this.name = customer.getName();
        this.mobilePhone = customer.getMobilePhone();
        this.status = customer.getStatus();
        this.createdAt = customer.getCreatedAt();
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
