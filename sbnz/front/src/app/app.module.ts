import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BaseLayoutComponent } from './pages/base-layout/base-layout.component';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { Interceptor } from './interceptors/interceptor.interceptor';
import { AuthService } from './services/auth.service';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OverlayModule } from '@angular/cdk/overlay';
import { WorkerModule } from './modules/worker/worker.module';
import { GuestModule } from './modules/guest/guest.module';

@NgModule({
  declarations: [
    AppComponent,
    BaseLayoutComponent,
    LoginComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    OverlayModule,
    GuestModule, 
    WorkerModule,
    ToastrModule.forRoot({
      positionClass: 'toast-top-right',
    })
  ],
  providers: [
    AuthService,
    { provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
