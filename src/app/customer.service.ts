import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Customer } from './customer';
import { Observable } from 'rxjs';
import { $ } from 'protractor';



@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  cemail:any;
  semail:any;
  iid:any;
  invoiceId:String;
  url = "http://localhost:8080";

  constructor(private _http : HttpClient) { 
    
  }

  public setInvoiceId(invoiceId:String):void{
    this.invoiceId=invoiceId;
  }

  public getInvoiceId():String{
    return this.invoiceId;
  }


  public addCustomer(customer:Customer,semail:string){
    var param=new HttpParams().append("semail",semail)
  return this._http.post<any>(this.url+"/addcustomer",customer,{params:param});
  }

  
public getCustomers(semail:string): Observable<any> {
  var param=new HttpParams().append("semail",semail)
  return this._http.get<any>(this.url+"/customers",{params:param});
}

public upload(fd :FormData):Observable<any>{
  return this._http.post<any>(this.url+"/uploadinvoices",fd);
}

public getInvoices(): Observable<any> {
  return this._http.get<any>(this.url+"/invoices");

} 

public postInvoice(fd:FormData):Observable<any>{
  return this._http.post<any>(this.url+"/invoice",fd);
}


public postId(fd1:FormData):Observable<any>{
  return this._http.post<any>(this.url+"/iid",fd1);
}

public sendMail():Observable<any>{
  return this._http.get<any>(this.url+"/mail");
}

public postPayment():Observable<any>{
  return this._http.post<any>(this.url+"/invoiceid",this.getInvoiceId());
}

public getPendingInvoices():Observable<any>{
  return this._http.get<any>(this.url+"/payment");
}

public makePay():Observable<any>{
  return this._http.post<any>(this.url+"/makepayment",this.getInvoiceId());
}

public getFrequency(semail:string,dateType:string,date:string):Observable<any>{
  var param=new HttpParams().append("dateType",dateType).append("date",date).append("semail",semail)
  return this._http.get<any>(this.url+"/frequency",{params:param});
}
}
