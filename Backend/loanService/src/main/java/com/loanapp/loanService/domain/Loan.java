package com.loanapp.loanService.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Loan {
    @Id
    private String email;
    private String customerName;
    private Double amount;
    private Integer term;
    private LocalDate approvalDate;
    private String status;

    // Getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Loan(String email,String customerName, Double amount, Integer term, LocalDate approvalDate, String status) {
        this.email = email;
        this.customerName=customerName;
        this.amount = amount;
        this.term = term;
        this.approvalDate = approvalDate;
        this.status = status;
    }

    public Loan() {
    }

    @Override
    public String toString() {
        return "Loan{" +
                "email=" + email +
                "customerName=" + customerName +
                ", amount=" + amount +
                ", term=" + term +
                ", approvalDate=" + approvalDate +
                ", status='" + status + '\'' +
                '}';
    }
}