package com.loanapp.loanService.repository;

import com.loanapp.loanService.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, String> {

//    Loan findByIdAndPassword(Long Id, String password);

    Loan findByEmail(String email);
}