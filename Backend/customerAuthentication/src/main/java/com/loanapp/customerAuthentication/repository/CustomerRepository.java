package com.loanapp.customerAuthentication.repository;

import com.loanapp.customerAuthentication.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    public Customer findByEmailAndPassword(String email, String password);
}
