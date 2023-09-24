package com.loanapp.customerAuthentication.service;

import com.loanapp.customerAuthentication.domain.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(Customer customer);
}
