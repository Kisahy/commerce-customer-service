package com.kisahy.commerce.customer.enums;

public enum CustomerStatus {
    ACTIVE(1),
    INACTIVE(0),
    SUSPENDED(2);

    private final int value;

    CustomerStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
