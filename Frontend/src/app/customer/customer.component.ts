import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoanService } from '../services/loan.service';
import { Customer } from 'src/models/Customer';
import Swal from 'sweetalert2';
import { LoanData } from 'src/models/LoanData';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
})
export class CustomerComponent {
  constructor(
    private activateRoute: ActivatedRoute,
    private fb: FormBuilder,
    private service: LoanService,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.service.getSingleCustomer().subscribe((data) => {
      this.loanData = data;
    });
  }

  loanData: LoanData = {
    email: '',
    customerName: '',
    amount: '',
    term: '',
    approvalDate: 0,
    status: '',
  };

  appyForLoan() {
    Swal.fire({
      title: 'Do you want to save the changes?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Save',
      denyButtonText: `Don't save`,
    }).then((result) => {
     
      if (result.isConfirmed) {
        this.loanData.approvalDate = 0;
        this.loanData.status = 'Pending';

        this.service.applyLoan(this.loanData).subscribe((response) => {
          let appliedData = response;
          console.log(appliedData);
        });

        Swal.fire('Saved!', '', 'success');
      } else if (result.isDenied) {
        Swal.fire('Changes are not saved', '', 'info');
      }
    });
  }
}
