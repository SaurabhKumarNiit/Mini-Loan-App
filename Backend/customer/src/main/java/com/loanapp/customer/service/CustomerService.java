package com.loanapp.customer.service;

import com.loanapp.customer.domain.Customer;
import com.loanapp.customer.exception.CustomerAlreadyExistsException;
import com.loanapp.customer.exception.CustomerNotFoundException;


public interface CustomerService {

    Customer registerCustomer(Customer customer) throws CustomerAlreadyExistsException;

//    public List<Customer> getAllCustomers() throws CustomerNotFoundException;

    Customer getCustomerByEmail(String email) throws CustomerNotFoundException;

//    public Customer updateCustomerDetails(Customer customer, String email);
}
