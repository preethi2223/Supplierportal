import { Component, OnInit } from '@angular/core';
import { SupplierLoginService } from '../supplier-login.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  constructor(public _service : SupplierLoginService) { }
  
  ngOnInit(): void {
                  
  }

}
