import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../models/Login';
import { Token } from '../models/Token';
import { User } from '../models/User';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private headers = new HttpHeaders({ "Content-Type": "application/json"});

  constructor(private http: HttpClient) {}

  login(auth: Login): Observable<Token> {
    return this.http.post<Token>("http://localhost:8081/api/auth/login", auth, {
      headers: this.headers,
      responseType: "json",
    });
  }

  setCurrentUser(token: Token): void {

    this.http.get<User>("http://localhost:8081/api/auth/getLoggedIn", {
      headers: this.headers,
      responseType: "json",
    }).subscribe(response => {
      localStorage.setItem("currentUser", JSON.stringify(response));
    });
  }

  getCurrentUser(): User | null{

    const jsonString = localStorage.getItem("currentUser");

    if(jsonString) return JSON.parse(jsonString);
    else return null;
  }

  logout(): Observable<string> {
    localStorage.removeItem("currentUser");
    localStorage.removeItem("userToken");

    return this.http.get("http://localhost:8081/api/auth/logOut", {
      headers: this.headers,
      responseType: "text",
    });
  }
}
