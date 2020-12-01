import { Injectable } from '@angular/core';
import { Supplier } from './supplier';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SupplierLoginService {

  constructor(private _http : HttpClient,private _router : Router) { }

  public loginSupplier(supplier :Supplier):Observable<any>{
    return this._http.post<any>("http://localhost:8080/login",supplier)
}

public isLogin(){
  let value = sessionStorage.getItem('semail');
  return !(value===null)
}

public logOut(){
  sessionStorage.removeItem('semail');
  this._router.navigate(['login'])
}
}
