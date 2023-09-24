package com.loanapp.customerAuthentication.service;

import com.loanapp.customerAuthentication.domain.Customer;

public interface EmailService {
//    String sendSimpleEmail(Customer customer);
//    String sendEmailWithAttachments(Customer customer);

    public boolean sendEmail(Customer customer);

    public boolean sendEmailInCustomerLogin(Customer customer);
}