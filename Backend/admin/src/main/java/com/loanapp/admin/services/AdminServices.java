package com.loanapp.admin.services;

import com.loanapp.admin.domain.Admin;

import java.util.List;

public interface AdminServices {

    Admin ApproveLoan(Admin approveRequest);

    Admin updateStatus(Admin adminData, String email);


    Admin getCustomerByEmail(String email);

    List<Admin> getAllCustomers();
}
