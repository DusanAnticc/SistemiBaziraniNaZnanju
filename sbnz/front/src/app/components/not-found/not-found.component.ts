import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.scss']
})
export class NotFoundComponent {

  constructor(
    private router : Router,
    private authService : AuthService
  ) { }

  redirect(){
    if(this.authService.getCurrentUser()){
      const role = this.authService.getCurrentUser()?.dtype;

      // if(role === "Admin") this.router.navigate(["admin/"]);


    }else this.router.navigate(["login"]);
  }

}
