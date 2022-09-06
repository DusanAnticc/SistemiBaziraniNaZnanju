import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar-worker',
  templateUrl: './navbar-worker.component.html',
  styleUrls: ['./navbar-worker.component.scss']
})
export class NavbarWorkerComponent {

  constructor(
    private authService : AuthService, 
    private router: Router
  ) { }

  logOut() {
    this.authService.logout();
    this.router.navigate(["login"]);
  }

}
