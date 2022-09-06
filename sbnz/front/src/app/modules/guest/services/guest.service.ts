import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class GuestService {

  private headers = new HttpHeaders({ "Content-Type": "application/json"});

  constructor(
    private http: HttpClient,
    private toastr: ToastrService
  ) { }
}
