package com.loanapp.admin.controller;

import com.loanapp.admin.domain.Admin;
import com.loanapp.admin.services.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:4200/")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;


 //    http://localhost:8590/api/admin/approveLoan

    @PostMapping("/approveLoan")
    public ResponseEntity<?> approveLoan(@RequestBody Admin approveRequest) {

        Admin adminServiceLoan = adminService.ApproveLoan(approveRequest);
        return new ResponseEntity<>(adminServiceLoan, HttpStatus.CREATED);
    }

    //    http://localhost:8590/api/admin/customer/{email}

    @GetMapping("/customer/{userId}")
    public ResponseEntity<?> getCustomerByUserId(@PathVariable String email) {

        Admin customerByUserId = adminService.getCustomerByEmail(email);
        return new ResponseEntity<>(customerByUserId, HttpStatus.OK);
    }

    //    http://localhost:8590/api/admin/customers

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers(){
        return new ResponseEntity<>(adminService.getAllCustomers(),HttpStatus.OK);
    }

    //    http://localhost:8590/api/admin/status/update/{email}

    @PutMapping("status/update/{email}")
    public ResponseEntity<?> updateStatus(@RequestBody Admin admin, @PathVariable String email){
        return new ResponseEntity<>(adminService.updateStatus(admin,email),HttpStatus.CREATED);
    }
}
