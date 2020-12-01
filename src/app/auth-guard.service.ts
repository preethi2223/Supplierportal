import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot,RouterStateSnapshot,Router } from '@angular/router';
import { SupplierLoginService } from './supplier-login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(public _service:SupplierLoginService,private _router:Router) { }
  canActivate(route:ActivatedRouteSnapshot,state:RouterStateSnapshot) {
    if(this._service.isLogin())
    return true;

    this._router.navigate(['login']);  
  }
}
