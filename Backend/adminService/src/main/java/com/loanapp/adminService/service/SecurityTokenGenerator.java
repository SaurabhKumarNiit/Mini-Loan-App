package com.loanapp.adminService.service;

import com.loanapp.adminService.domain.Admin;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(Admin admin);
}
