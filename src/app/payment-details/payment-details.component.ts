import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Invoices } from '../invoices';

@Component({
  selector: 'app-payment-details',
  templateUrl: './payment-details.component.html',
  styleUrls: ['./payment-details.component.css']
})
export class PaymentDetailsComponent implements OnInit {

  invoiceId:String;
  data:any;
  invoices=new Invoices();

  constructor(private _service : CustomerService) { }

  ngOnInit(): void {
  }

  makePayment(){
    this.invoiceId = this._service.getInvoiceId();
     this._service.makePay().subscribe(data=>{
       alert("Payment Successfull");
     })
  }
}
