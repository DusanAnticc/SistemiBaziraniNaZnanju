import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from "../services/auth.service";
import { JwtHelperService } from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate {
  constructor(public auth: AuthService, public router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRoles: string = route.data["expectedRoles"];
    const token = localStorage.getItem("userToken");
    const jwt: JwtHelperService = new JwtHelperService();

    if (!token) {
      this.router.navigate(["login"]);
      return false;
    }

    const info = jwt.decodeToken(token);
    // const roles: string[] = expectedRoles.split("|", 2);

    
    if(info.sub !== this.auth.getCurrentUser()?.username){
      this.router.navigate(["login"]);
      return false;
    }
    
    if(!this.auth.getCurrentUser()) return false;

    const currentUserRole = this.auth.getCurrentUser()?.dtype!;


    // if (roles.indexOf(currentUserRole) === -1) {
    //   this.router.navigate(["login"]);
    //   return false;
    // }
    
    return true;
  }
}
