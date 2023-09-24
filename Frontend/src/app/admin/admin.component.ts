import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ServiceService } from '../services/service.service';
import { LoanData } from 'src/models/LoanData';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent {
  loanData: LoanData[] = [];

  constructor(private service: ServiceService, private router: Router) {}

  ngOnInit(): void {
    this.service.getCustomers().subscribe({
      next: (data) => {
        this.loanData = data;
      },
      error: (e) => {
        alert('Failed due to Network Error');
      },
    });
  }

  logOut() {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, LogOut!',
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire('LogOut!', 'Your are Logout...', 'success'),
          localStorage.removeItem('email'),
          this.router.navigateByUrl('/login'),
          console.log('Log Out Success');
      }
    });
  }
}
