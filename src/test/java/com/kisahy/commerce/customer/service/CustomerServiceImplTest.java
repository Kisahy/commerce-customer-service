package com.kisahy.commerce.customer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kisahy.commerce.customer.dto.CustomerResponse;
import com.kisahy.commerce.customer.dto.SignUpRequest;
import com.kisahy.commerce.customer.entity.Customer;
import com.kisahy.commerce.customer.exception.DuplicateEmailException;
import com.kisahy.commerce.customer.repository.CustomerRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private SignUpRequest request;

    @BeforeEach
    void setUp() {
        request = new SignUpRequest(
                "test@example.com",
                "password1!",
                "홍길동",
                "010-1234-5678"
        );
    }

    @Test
    @DisplayName("정상 회원가입")
    void sinUp_success() {
        given(customerRepository.existsByEmail(any())).willReturn(false);
        given(passwordEncoder.encode(any())).willReturn("encodedPassword");
        given(customerRepository.save(any(Customer.class)))
                .willAnswer(invocation -> invocation.getArgument(0));

        CustomerResponse response = customerService.signUp(request);

        assertThat(response).isNotNull();
        assertThat(response.getEmail()).isEqualTo("test@example.com");
        assertThat(response.getName()).isEqualTo("홍길동");
        assertThat(response.getMobilePhone()).isEqualTo("010-1234-5678");
    }

    @Test
    @DisplayName("이메일 중복 시 예외 발생")
    void signUp_duplicateEmail_throwsException() {
        given(customerRepository.existsByEmail(any())).willReturn(true);

        assertThatThrownBy(() -> customerService.signUp(request))
                .isInstanceOf(DuplicateEmailException.class)
                .hasMessage("이미 사용 중인 이메일입니다.");
    }
}
