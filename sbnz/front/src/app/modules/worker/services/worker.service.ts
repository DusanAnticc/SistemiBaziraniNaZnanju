import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SteamMachine } from 'src/app/models/SteamMachine';
import { ToastrService } from 'ngx-toastr';
import { TemplateModel } from 'src/app/models/TemplateModel';
import { Log } from 'src/app/models/Log';

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

  updateMachine(machineId: number, newSteamValue: number): void{
    this.http.post<Request>("http://localhost:8081/api/steam-machine/update/" + machineId + "/" + newSteamValue, {
      headers: this.headers,
      responseType: "json",
    }).subscribe(() => {
      this.toastr.success("Machine " + machineId + " updated!");
    });
  }

  getAllLogsForMachine(machineId: number): Observable<Log[]>{
    return this.http.get<Log[]>("http://localhost:8081/api/log/machine/" + machineId, {
      headers: this.headers,
      responseType: "json",
    });
  }
  
  callRepairman(machineId: number): void{
    this.http.post<Request>("http://localhost:8081/api/service-log/" + machineId, {
      headers: this.headers,
      responseType: "json",
    }).subscribe(() => {
      this.toastr.success("Repairman called!");
    });
  }
}
