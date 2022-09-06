import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { GuestRoutes } from './guest.routes';
import { PayComponent } from './components/pay/pay.component';

@NgModule({
  declarations: [
    PayComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule.forChild(GuestRoutes)
  ]
})
export class GuestModule { }
