import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SteamMachine } from 'src/app/models/SteamMachine';

@Injectable({
  providedIn: 'root'
})
export class WorkerService {

  private headers = new HttpHeaders({ "Content-Type": "application/json"});

  constructor(private http: HttpClient) {}

  getAllStramMachines(): Observable<SteamMachine[]>{
    return this.http.get<SteamMachine[]>("http://localhost:8081/api/steam-machine", {
      headers: this.headers,
      responseType: "json",
    });
  }

}
