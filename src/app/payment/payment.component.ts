import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { Invoices } from '../invoices';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  data:any;
  msg:any;
 invoices=new Invoices();
  
  constructor(private _service : CustomerService,private _router : Router) { }

  ngOnInit():void {
    
  }

  payment(){
  
    this._service.setInvoiceId(this.invoices.iid);
    this._service.postPayment().subscribe(
      data=>{
      if(data=="0"){
        this.msg=("Invoice doesn't exists");
      }
      else if(data=="1"){
        this.msg=("Already paid");
      }
      else {
        this._router.navigate(['/payment']);
      }
    })
  }

}
