import { Component, OnInit } from '@angular/core';
import { SupplierLoginService } from '../supplier-login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private _service : SupplierLoginService,private _router: Router) { }

  ngOnInit(){
    this._service.logOut();
    this._router.navigate(['login']);
  }

}
