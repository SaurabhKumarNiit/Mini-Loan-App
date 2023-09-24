// loan.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from 'src/models/Customer';
import { LoanData } from 'src/models/LoanData';

@Injectable({
  providedIn: 'root',
})
export class LoanService {
  data: any;

  constructor(private http: HttpClient) {}

  getEmail() {
    return localStorage.getItem('email');
  }

  getSingleCustomer(): Observable<Customer> {
    this.data = this.getEmail();
    return this.http.get<Customer>(
      `${'http://localhost:8090/api/customer/customers'}/${this.data}`
    );
  }

  getSingleCustomerForLoan(email: any): Observable<Customer> {
    return this.http.get<Customer>(
      `${'http://localhost:8990/api/loanService/loanDetails'}/${email}`
    );
  }

  getCustomers(): Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>(
      'http://localhost:8081/customerservice/v1/customers'
    );
  }

  updateCustomerStatus(email?: string, loanData?: LoanData) {
    return this.http.put<Customer>(
      `${' http://localhost:8590/api/admin/status/update'}/${email}`,
      loanData
    );
  }

  getCustomerLoanData(): Observable<LoanData> {
    this.data = this.getEmail();
    return this.http.get<LoanData>(
      `${'http://localhost:8990/api/loanService/loanDetails'}/${this.data}`
    );
  }

  applyLoan(data: any) {
    console.log(data);
    return this.http.post<any>(
      'http://localhost:8990/api/loanService/loan',
      data
    );
  }
}
