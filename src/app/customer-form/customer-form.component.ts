import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit{

  customer = new Customer();
  
  msg = '';
  public userFile: any = File;
	 
  constructor(private _service : CustomerService,private _router : Router) {
    this.customer = new Customer();
  }
  
  ngOnInit(): void {
  }

  addcustomer(){
    var semail=sessionStorage.getItem('semail');
    this._service.addCustomer(this.customer,semail).subscribe(

      result => {
        if(result=="1"){
        this.msg=("Mail already exists");
        
        }
        else{
        this._router.navigate(['/customers']);
        }},
        error=>{
        console.log("Exception occured");
        this.msg="Bad Response";
        
        }
        );
      }


  /*gotoCustomerList() {
    this._router.navigate(['/customers']);
  }  */
  

}
