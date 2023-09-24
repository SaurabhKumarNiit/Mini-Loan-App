import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { HomeComponent } from './home/home.component';
import { LoginInterfaceComponent } from './login-interface/login-interface.component';
import { RegisterInterfaceComponent } from './register-interface/register-interface.component';
import { AdminComponent } from './admin/admin.component';
import { LoanStatusComponent } from './loan-status/loan-status.component';
import { SelectCustomerComponent } from './admin/select-customer/select-customer.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},

  {path:'login',component:LoginInterfaceComponent},

  {path:'',redirectTo:'/login',pathMatch:'full'},
  
  {path:'customer',component:CustomerComponent},

  {path:'login',component:LoginInterfaceComponent},
  
  {path:'register',component:RegisterInterfaceComponent},

  {path:'admin',component:AdminComponent},

  {path:'loanStatus',component:LoanStatusComponent},

  {path:'admin/:email',component:SelectCustomerComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
