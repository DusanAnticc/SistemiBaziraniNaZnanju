import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar-guest',
  templateUrl: './navbar-guest.component.html',
  styleUrls: ['./navbar-guest.component.scss']
})
export class NavbarGuestComponent {

  constructor(
    private authService : AuthService, 
    private router: Router
  ) { }

  logOut() {
    this.authService.logout();
    this.router.navigate(["login"]);
  }

}
