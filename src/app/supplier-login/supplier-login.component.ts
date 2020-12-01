import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Supplier } from '../supplier';
import { SupplierLoginService } from '../supplier-login.service';
import { Router } from '@angular/router';
import { CustomerFormComponent } from '../customer-form/customer-form.component';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-supplier-login',
  templateUrl: './supplier-login.component.html',
  styleUrls: ['./supplier-login.component.css']
})
export class SupplierLoginComponent implements OnInit {

  supplier = new Supplier();
  msg = '';
  constructor(private _service : SupplierLoginService,private _router : Router,private service : CustomerService) { }

  ngOnInit(): void {
  }

  loginSupplier(){
    this._service.loginSupplier(this.supplier).subscribe(
      data => {
        this.service.semail=data.semail;
        sessionStorage.setItem('semail',data.semail);
        console.log("Login Successfully");
        alert("Login Successfully");
        this._router.navigate(['/customers']);
      },
      error => {
        console.log("Exception Occured");
        this.msg="Email and Password doesn't exists.";
        
      }
    )
  }

}
