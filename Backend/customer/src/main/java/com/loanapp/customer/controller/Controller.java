package com.loanapp.customer.controller;


import com.loanapp.customer.domain.Customer;
import com.loanapp.customer.exception.CustomerAlreadyExistsException;
import com.loanapp.customer.exception.CustomerNotFoundException;
import com.loanapp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("http://localhost:4200/")
public class Controller {

    private  ResponseEntity responseEntity;

    @Autowired
    private CustomerService customerService;


    // http://localhost:8090/api/customer/register

    @PostMapping("/register")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
        Customer customer1 = null;
        try {
            customer1 = customerService.registerCustomer(customer);
        } catch (CustomerAlreadyExistsException e) {
            throw new CustomerAlreadyExistsException();
        }
        return responseEntity=new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    // http://localhost:8090/api/customer/customers/{email}

    @GetMapping("/customers/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        try {
            responseEntity = new ResponseEntity<>(customerService.getCustomerByEmail(email),HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
