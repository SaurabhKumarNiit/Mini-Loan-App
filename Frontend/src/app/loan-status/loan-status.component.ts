import { Component } from '@angular/core';
import { LoanService } from '../services/loan.service';
import { Router } from '@angular/router';
import { LoanData } from 'src/models/LoanData';

@Component({
  selector: 'app-loan-status',
  templateUrl: './loan-status.component.html',
  styleUrls: ['./loan-status.component.css']
})
export class LoanStatusComponent {

  constructor(private loanService: LoanService,private router:Router) {}


  customerLoan:LoanData[]=[]
 
  loans: LoanData = {  email:'',customerName: '', amount:'',term:'',approvalDate:'',status:''};

 ngOnInit(): void {

   this.loanService.getCustomerLoanData().subscribe({
     next:data=>{
       this.loans=data;
     },
     error:e=>{
     alert("Failed due to Network Error");
     }
   });
 }
}
