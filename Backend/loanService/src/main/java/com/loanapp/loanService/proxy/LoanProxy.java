package com.loanapp.loanService.proxy;


import com.loanapp.loanService.domain.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="admin-service",url="http://localhost:8590")
public interface LoanProxy {

    @PostMapping("/api/admin/approveLoan")
   ResponseEntity<?> customerLoan(@RequestBody Loan loan);


}