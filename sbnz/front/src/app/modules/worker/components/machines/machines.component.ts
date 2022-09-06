import { Component, OnInit } from '@angular/core';
import { SteamMachine } from 'src/app/models/SteamMachine';
import { WorkerService } from '../../services/worker.service';

@Component({
  selector: 'app-machines',
  templateUrl: './machines.component.html',
  styleUrls: ['./machines.component.scss']
})
export class MachinesComponent implements OnInit {

  steamMachines: SteamMachine[] = [];

  constructor(
    private workerService: WorkerService
  ) { }

  ngOnInit(): void {
    this.workerService.getAllStramMachines().subscribe((response) => {
      this.steamMachines = response;
      console.log(this.steamMachines)
    });
  }

}
