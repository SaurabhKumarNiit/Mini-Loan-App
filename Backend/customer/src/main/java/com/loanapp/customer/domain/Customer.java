package com.loanapp.customer.domain;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer {
    @Id
    private String email;
    private String customerName;
    private String password;
    private String mobileNo;
//    private String profileDp;


    public Customer(String email, String customerName, String password, String mobileNo) {
        this.email = email;
        this.customerName = customerName;
        this.password = password;
        this.mobileNo = mobileNo;
    }

    public Customer() {
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}