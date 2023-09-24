package com.loanapp.loanService.services;

import com.loanapp.loanService.domain.Loan;

public interface LoanService {

     Loan createLoan(Loan loanRequest);

    Loan updateStatus(Loan adminData, String email);
    Loan getLoanByEmail(String email);
}
