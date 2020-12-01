import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { SupplierRegistrationService } from '../supplier-registration.service';
import { UploadInvoicesComponent } from '../upload-invoices/upload-invoices.component';

@Component({
  selector: 'app-invoices-list',
  templateUrl: './invoices-list.component.html',
  styleUrls: ['./invoices-list.component.css']
})
export class InvoicesListComponent implements OnInit {

  fd = new FormData();
  msg:any;
  data : any;
  value:boolean;
  cemail:any;
  constructor(private _service : CustomerService) { }

  ngOnInit() {
    
    this._service.getInvoices().subscribe(data => {
      if(data.length>0){
      this.data = data;
      this.cemail=this._service.cemail;
      this.value = true;
      }
      else{
        this.cemail=this._service.cemail;
        this.value = false;
      }
    });

  }
  file(fd:FormData){
    
    this._service.iid=fd;
  
    const fd1  = new FormData();
    fd1.append('iid',this._service.iid);
    this._service.postId(fd1).subscribe(data=>{});
    
    this._service.sendMail().subscribe(data=>{
      this.msg=("Mail Sent Successfully")
       
      })
  }


}
