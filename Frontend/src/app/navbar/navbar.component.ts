import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Customer } from 'src/models/Customer';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {


  public totalItem : number = 0;
  public searchTerm !: string;

  // currentGame: string ="";
  constructor(private router:Router ) { 
    // this.currentGame = JSON.parse(localStorage.getItem('currentGame')); 
  }

  ngOnInit(): void {
   
  }



logIn(){
  if(localStorage.getItem('email')){
    this.router.navigateByUrl('/home'),

    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'First LogOut then LogIn agin!',
      
    })
    
  }else{
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Redirected To login page',
      showConfirmButton: false,
      timer: 1500
    })
  }
}


  logOut(){

    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, LogOut!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'LogOut!',
          'Your are Logout...',
          'success'
        ),
        localStorage.removeItem('email'),
          this.router.navigateByUrl('/login'),
          console.log("Log Out Success")
      }
    })
  }


}
