package com.loanapp.customer.repository;

import com.loanapp.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

    Customer findByEmailAndPassword(String email, String password);
    Customer findByEmail(String email);
}
