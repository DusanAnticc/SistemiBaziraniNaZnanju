import { Component, OnInit } from '@angular/core';
import { SteamMachine } from 'src/app/models/SteamMachine';
import { WorkerService } from '../../services/worker.service';
import { ToastrService } from 'ngx-toastr';
import { TemplateModel } from 'src/app/models/TemplateModel';

@Component({
  selector: 'app-check-machines',
  templateUrl: './check-machines.component.html',
  styleUrls: ['./check-machines.component.scss']
})
export class CheckMachinesComponent implements OnInit {

  steamMachines: SteamMachine[] = [];

  constructor(
    private workerService: WorkerService,
    private toastrService: ToastrService
  ) { }

  ngOnInit(): void {
    this.workerService.getAllStramMachines().subscribe((response) => {
      this.steamMachines = response;
    });
  }

  checkMachines() {
    let checkedSteamMachines: number[]  = [];

    for (var steamMachine of this.steamMachines) {
      let element = <HTMLInputElement> document.getElementById(steamMachine.id.toString());  
      if (element.checked) {
        checkedSteamMachines.push(Number(element.value));
      }
    }

    if (checkedSteamMachines.length == 0) {
      this.toastrService.error('None of the machines are selected!');
    } else {
      const templateModel: TemplateModel = {
        idMachines: checkedSteamMachines,
        lowerLimit: Number((<HTMLInputElement>document.getElementById("minTemp")).value),
        upperLimit: Number((<HTMLInputElement>document.getElementById("maxTemp")).value)
      };
      this.workerService.checkMachines(templateModel);
    }
  }

}
