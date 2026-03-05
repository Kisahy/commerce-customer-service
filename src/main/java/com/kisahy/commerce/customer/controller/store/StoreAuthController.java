package com.kisahy.commerce.customer.controller.store;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kisahy.commerce.customer.dto.LoginRequest;
import com.kisahy.commerce.customer.dto.LoginResponse;
import com.kisahy.commerce.customer.service.StoreAuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/store/auth")
public class StoreAuthController {
    private final StoreAuthService storeAuthService;

    public StoreAuthController(StoreAuthService storeAuthService) {
        this.storeAuthService = storeAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody @Valid LoginRequest request
    ) {
        return ResponseEntity.ok(storeAuthService.login(request));
    }
}