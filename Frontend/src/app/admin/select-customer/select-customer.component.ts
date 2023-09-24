import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoanService } from 'src/app/services/loan.service';
import { LoanData } from 'src/models/LoanData';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-select-customer',
  templateUrl: './select-customer.component.html',
  styleUrls: ['./select-customer.component.css'],
})
export class SelectCustomerComponent {
  loanData: LoanData = {
    email: '',
    customerName: '',
    amount: '',
    term: '',
    approvalDate: 0,
    status: '',
  };

  constructor(
    private loanService: LoanService,
    private activateRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe((params) => {
      let email = params.get('email') ?? '';
      this.loanService.getSingleCustomerForLoan(email).subscribe((data) => {
        this.loanData = data;
      });
    });
  }

  updateData() {
    this.loanData.status = 'Approved';
    this.loanService
      .updateCustomerStatus(this.loanData.email, this.loanData)
      .subscribe({
        next: (data) => {
          Swal.fire({
            icon: 'success',
            title: 'Done',
            text: 'Loan Approved Successfully',
          });
        },
        error: (e) => {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
          });
        },
      });
    this.router.navigateByUrl('/admin');
  }

  removeData() {
    this.loanData.status = 'Rejected';
    this.loanService
      .updateCustomerStatus(this.loanData.email, this.loanData)
      .subscribe({
        next: (data) => {
          Swal.fire({
            icon: 'success',
            title: 'Done',
            text: 'Loan Rejected Successfully !',
          });
        },
        error: (e) => {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
          });
        },
      });
    this.router.navigateByUrl('/admin');
  }
}
