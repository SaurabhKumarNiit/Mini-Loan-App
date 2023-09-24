package com.loanapp.loanService.controller;

import com.loanapp.loanService.domain.Loan;
import com.loanapp.loanService.services.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loanService")
@CrossOrigin("http://localhost:4200/")
public class LoanController {

    @Autowired
    private LoanServiceImpl loanService;

    //    http://localhost:8990/api/loanService/loan

    @PostMapping("/loan")
    public ResponseEntity<?> createLoan(@RequestBody Loan loanRequest) {

        Loan loanServiceLoan = loanService.createLoan(loanRequest);
        return new ResponseEntity<>(loanServiceLoan, HttpStatus.CREATED);
    }


    //    http://localhost:8990/api/loanService/loanDetails/{email}

    @GetMapping("loanDetails/{email}")
    public ResponseEntity<?> getLoanDetails(@PathVariable String email) {

        Loan loanByUserId = loanService.getLoanByEmail(email);
        return new ResponseEntity<>(loanByUserId, HttpStatus.OK);
    }


    //    http://localhost:8990/api/loanService/status/update/{email}

    @PutMapping("status/update/{email}")
    public ResponseEntity<?> updateStatus(@RequestBody Loan loan, @PathVariable String email){
        return new ResponseEntity<>(loanService.updateStatus(loan,email),HttpStatus.CREATED);
    }
}
