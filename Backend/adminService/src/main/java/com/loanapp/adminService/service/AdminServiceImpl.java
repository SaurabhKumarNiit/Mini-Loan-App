package com.loanapp.adminService.service;

import com.loanapp.adminService.domain.Admin;
import com.loanapp.adminService.exception.AdminNotFoundException;
import com.loanapp.adminService.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin findByEmailAndPassword(String email, String password) throws AdminNotFoundException {
        Admin admin = adminRepository.findByEmailAndPassword(email, password);
        if (admin == null){
            throw new AdminNotFoundException();
        }
        return admin;
    }
}
