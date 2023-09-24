package com.loanapp.customer.service;

import com.loanapp.customer.domain.Customer;

import com.loanapp.customer.exception.CustomerAlreadyExistsException;
import com.loanapp.customer.exception.CustomerNotFoundException;
import com.loanapp.customer.proxy.CustomerProxy;
import com.loanapp.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    private CustomerProxy customerProxy;



    @Autowired
    public CustomerServiceImpl(CustomerProxy customerProxy) {
        this.customerProxy=customerProxy;
    }

    @Override
    public Customer registerCustomer(Customer customer) throws CustomerAlreadyExistsException {
        if(customerRepository.findById(customer.getEmail()).isPresent()){
            throw new CustomerAlreadyExistsException();
        }
        Customer addCustomer= customerRepository.save(customer);

        if(!(addCustomer.getEmail().isEmpty())){
            ResponseEntity responseEntity = customerProxy.saveCustomer(customer);
            System.out.println(responseEntity.getBody());
        }
        return addCustomer;
    }

    @Override
    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {
        return customerRepository.findByEmail(email);
    }
}
