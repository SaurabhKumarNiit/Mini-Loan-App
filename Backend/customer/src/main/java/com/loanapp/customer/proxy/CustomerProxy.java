package com.loanapp.customer.proxy;

import com.loanapp.customer.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authentication-service",url="http://localhost:8094")
public interface CustomerProxy {

    @PostMapping("/customer/v1/register")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer);
}
