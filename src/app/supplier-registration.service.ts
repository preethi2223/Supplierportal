import { Injectable } from '@angular/core';
import { Supplier } from './supplier';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class SupplierRegistrationService {
  
  constructor(private _http : HttpClient) { }

  public registerSupplier(supplier :Supplier):Observable<any>{
    return this._http.post<any>("http://localhost:8080/registersupplier",supplier)
}
}
