import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Supplier } from '../supplier';
import { SupplierRegistrationService } from '../supplier-registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-supplier-registration',
  templateUrl: './supplier-registration.component.html',
  styleUrls: ['./supplier-registration.component.css']
})
export class SupplierRegistrationComponent implements OnInit {

  supplier = new Supplier();
  msg='';
  

  constructor(private _service : SupplierRegistrationService,private _router : Router) { }

  ngOnInit(): void {
  }

  registerSupplier(){
    this._service.registerSupplier(this.supplier).subscribe(
      
      data => {
        if(data=="1"){
        alert("Mail already exists");
      }
       
      else{
        this.msg=("Registerd Successfully");
        console.log("Successfully Registered");
        alert("Registered Successfully");
        this._router.navigate(['/login']);
      }},
      error => {
        console.log("Exception occured");
        this.msg="Bad Response";
        
      });
      
    
  }
}
