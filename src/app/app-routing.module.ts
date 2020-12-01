import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { SupplierLoginComponent } from './supplier-login/supplier-login.component';
import { SupplierRegistrationComponent } from './supplier-registration/supplier-registration.component';
import { UploadInvoicesComponent } from './upload-invoices/upload-invoices.component';
import { LogoutComponent } from './logout/logout.component';
import { AppComponent } from '../app/app.component';
import { AuthGuardService } from './auth-guard.service';
import { InvoicesListComponent } from './invoices-list/invoices-list.component';
import { PendingInvoicesComponent } from './pending-invoices/pending-invoices.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentDetailsComponent } from './payment-details/payment-details.component';
import { FiltersComponent } from './filters/filters.component';




const routes: Routes = [
  
  {path:'registersupplier',component:SupplierRegistrationComponent},
  {path:'login',component:SupplierLoginComponent},
  {path:'addcustomer',component:CustomerFormComponent,canActivate:[AuthGuardService]},
  {path: 'customers',component:CustomerListComponent,canActivate:[AuthGuardService]},
  {path:'uploadinvoices',component:UploadInvoicesComponent,canActivate:[AuthGuardService]},
  {path:'invoices',component:InvoicesListComponent,canActivate:[AuthGuardService]},
  {path:'payment',component:PendingInvoicesComponent},
  {path:'invoiceid',component:PaymentComponent},
  {path:'makepayment',component:PaymentDetailsComponent},
  {path:'frequency',component:FiltersComponent,canActivate:[AuthGuardService]},
  {path:'logout',component:LogoutComponent,canActivate:[AuthGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
