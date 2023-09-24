package com.loanapp.loanService.services;

import com.loanapp.loanService.domain.Loan;
import com.loanapp.loanService.proxy.LoanProxy;
import com.loanapp.loanService.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    LoanRepository loanRepository=null;

    private LoanProxy loanProxy;



    @Autowired
    public LoanServiceImpl(LoanProxy loanProxy) {
        this.loanProxy = loanProxy;
    }

    @Override
    public Loan createLoan(Loan loanRequest) {

        Loan createLoan=loanRepository.save(loanRequest);

//        if(!(createLoan.getUserId())){
        ResponseEntity responseEntity = loanProxy.customerLoan(loanRequest);
        System.out.println(responseEntity.getBody());
//        }

        return createLoan;
    }

    @Override
    public Loan updateStatus(Loan loanData, String email) {

            Optional<Loan> optionalLoan = loanRepository.findById(email);
            if(optionalLoan.isEmpty()){
                return null;
            }

            Loan existingStatus = optionalLoan.get();
            if (loanData.getStatus()!=null){
                existingStatus.setStatus(loanData.getStatus());
            }
            return loanRepository.save(existingStatus);
        }



    @Override
    public Loan getLoanByEmail(String email) {
        return loanRepository.findByEmail(email);
    }
}
