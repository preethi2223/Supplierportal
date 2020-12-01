import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-pending-invoices',
  templateUrl: './pending-invoices.component.html',
  styleUrls: ['./pending-invoices.component.css']
})
export class PendingInvoicesComponent implements OnInit {

  data:any;
 
  
  constructor(private _service : CustomerService) { }
  
  ngOnInit(){
    this._service.getPendingInvoices().subscribe(data => {
      this.data = data;
     });
     
  }

 

}
