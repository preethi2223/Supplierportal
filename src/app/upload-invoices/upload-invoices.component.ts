import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { SupplierLoginService } from '../supplier-login.service';

@Component({
  selector: 'app-upload-invoices',
  templateUrl: './upload-invoices.component.html',
  styleUrls: ['./upload-invoices.component.css']
})
export class UploadInvoicesComponent implements OnInit {

  customer = new Customer();
  selectedFile = null;
  
  constructor(private _service : CustomerService,private _router : Router,private service:SupplierLoginService) { }
  cemail=this._service.cemail;
  onFileSelected(event){
    this.selectedFile = event.target.files[0];
  }

  onUpload(){
    const fd = new FormData();
    fd.append('file',this.selectedFile,this.selectedFile.name);
    fd.append('cemail',this._service.cemail);
    fd.append('semail',this._service.semail);
    this._service.upload(fd).subscribe(result =>{
    alert("File Uploaded Successfully");
      
    });
  }
  
  ngOnInit(): void {
  }

}
