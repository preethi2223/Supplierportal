import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Supplier } from '../supplier';
import { SupplierLoginService } from '../supplier-login.service';
import { setMaxListeners } from 'cluster';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  
  data:any;
  value:boolean;
  
  
  constructor(private _service : CustomerService) {
   
  }

  ngOnInit() {
    var semail=sessionStorage.getItem('semail');
    this._service.getCustomers(semail).subscribe(data => {
    if(data.length>0){
     this.data = data;
     this.value = true;
    }
    else{
      this.value = false;
    }
    });
  }
  
  upload(customer:Customer){  
  this._service.cemail=customer;
  const fd = new FormData();
  fd.append('cemail',this._service.cemail);
 
  this._service.postInvoice(fd).subscribe(data=>
{})
  }
 
}
