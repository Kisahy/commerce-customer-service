package com.kisahy.commerce.customer.dto;

import java.time.LocalDateTime;

import com.kisahy.commerce.customer.entity.Customer;

public class CustomerResponse {
    private final Long id;
    private final String email;
    private final String name;
    private final String phone;
    private final int status;
    private final LocalDateTime createdAt;

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.email = customer.getEmail();
        this.name = customer.getName();
        this.phone = customer.getPhone();
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

    public String getPhone() {
        return phone;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
