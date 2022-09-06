import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SteamMachine } from 'src/app/models/SteamMachine';
import { ToastrService } from 'ngx-toastr';
import { TemplateModel } from 'src/app/models/TemplateModel';

@Injectable({
  providedIn: 'root'
})
export class WorkerService {

  private headers = new HttpHeaders({ "Content-Type": "application/json"});

  constructor(
    private http: HttpClient,
    private toastr: ToastrService
  ) {}

  getAllStramMachines(): Observable<SteamMachine[]>{
    return this.http.get<SteamMachine[]>("http://localhost:8081/api/steam-machine", {
      headers: this.headers,
      responseType: "json",
    });
  }

  checkMachines(templateModel: TemplateModel): void{
    this.http.post<Request>("http://localhost:8081/api/logTemperature/testCompile", templateModel, {
      headers: this.headers,
      responseType: "json",
    }).subscribe(() => {
      this.toastr.success("Template created!");
    });
  }
  
}
