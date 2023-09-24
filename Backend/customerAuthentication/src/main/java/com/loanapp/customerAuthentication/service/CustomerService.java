package com.loanapp.customerAuthentication.service;

import com.loanapp.customerAuthentication.domain.Customer;
import com.loanapp.customerAuthentication.exception.CustomerNotFoundException;

public interface CustomerService {
    public Customer addCustomer(Customer customer);

    public Customer findByEmailAndPassword(String email,String password) throws CustomerNotFoundException;

}
