package com.loanapp.admin.services;

import com.loanapp.admin.domain.Admin;
import com.loanapp.admin.proxy.AdminProxy;
import com.loanapp.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminServices{

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminProxy adminProxy;
    @Override
    public Admin ApproveLoan(Admin approveRequest) {
        return adminRepository.save(approveRequest);
    }

    @Override
    public Admin updateStatus(Admin adminData, String email) {
        Optional<Admin> optionalAdmin = adminRepository.findById(email);
        if(optionalAdmin.isEmpty()){
            return null;
        }

        Admin existingStatus = optionalAdmin.get();
        if (adminData.getStatus()!=null){
            existingStatus.setStatus(adminData.getStatus());
        }
        Admin adminResponse = adminRepository.save(existingStatus);

        ResponseEntity responseEntity = adminProxy.updateStatus(existingStatus,email);
        System.out.println(responseEntity.getBody());

        return adminResponse;
    }

    @Override
    public Admin getCustomerByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public List<Admin> getAllCustomers() {
        return adminRepository.findAll();
    }
}
