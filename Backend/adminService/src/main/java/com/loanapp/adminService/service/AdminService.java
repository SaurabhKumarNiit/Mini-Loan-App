package com.loanapp.adminService.service;

import com.loanapp.adminService.domain.Admin;
import com.loanapp.adminService.exception.AdminNotFoundException;

public interface AdminService {
    public Admin addAdmin(Admin admin);

    public Admin findByEmailAndPassword(String email,String password) throws AdminNotFoundException;

}
