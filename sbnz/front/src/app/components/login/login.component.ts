import { Component } from '@angular/core';
import { Login } from 'src/app/models/Login';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { Token } from 'src/app/models/Token';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor(
    private authService: AuthService,
    private router: Router,
    private toastrService: ToastrService
  ) { }

  logIn() {
    if ((<HTMLInputElement>document.getElementById("username")).value == '' ||
    (<HTMLInputElement>document.getElementById("password")).value == '') {
      this.toastrService.error('Username/password field is empty!');
    } else {
      const auth: Login = {
        username: (<HTMLInputElement>document.getElementById("username")).value,
        password: (<HTMLInputElement>document.getElementById("password")).value,
      };

      this.authService.login(auth).subscribe({
        next: (result) => {
          localStorage.setItem('userToken', JSON.stringify(result));
          const tokenString = localStorage.getItem('userToken');

          if (tokenString) {
            const token: Token = JSON.parse(tokenString);
            this.authService.setCurrentUser(token);

            const role = this.authService.getCurrentUser()?.dtype!;

            if(role === "Worker") this.router.navigate(["worker/machines"]);
            if(role === "Guest") this.router.navigate(["guest/pay"]);
          }
        },
        error: (error) => {
          if (error.status === 400) this.toastrService.error('Bad credentials!');
        },
      });
    }
  }

}
