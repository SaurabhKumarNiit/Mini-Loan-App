package com.loanapp.admin.proxy;

import com.loanapp.admin.domain.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="customer-loan-service",url="http://localhost:8990")
public interface AdminProxy {


@PutMapping("api/loanService/status/update/{email}")
 ResponseEntity<?> updateStatus(@RequestBody Admin loan, @PathVariable String email);
}
