import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) {}

  
  registerCustomer(data:any) {
    console.log(data);
    return this.http.post<any>("http://localhost:8090/api/customer/register",data);
  }

  loginCustomer(data:any):Observable<any>{
    return this.http.post<any>("http://localhost:8094/customer/v1/login",data);
  }

  loginAdmin(data:any):Observable<any>{
    return this.http.post<any>("http://localhost:8085/admin/login",data);
  }

  getCustomers() {
   
    return this.http.get<any>("http://localhost:8590/api/admin/customers");
  }

}
