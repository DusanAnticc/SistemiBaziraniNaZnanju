import { Component, OnInit } from '@angular/core';
import { SteamMachine } from 'src/app/models/SteamMachine';
import { WorkerService } from '../../services/worker.service';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { UpdateMachineModalComponent } from '../../modals/update-machine-modal/update-machine-modal.component';
import { FailureHistoryModalComponent } from '../../modals/failure-history-modal/failure-history-modal.component';

@Component({
  selector: 'app-machines',
  templateUrl: './machines.component.html',
  styleUrls: ['./machines.component.scss'],
  providers: [MdbModalService]
})
export class MachinesComponent implements OnInit {

  steamMachines: SteamMachine[] = [];
  modalRef: MdbModalRef<UpdateMachineModalComponent>

  constructor(
    private workerService: WorkerService,
    private modalService: MdbModalService
  ) { }

  ngOnInit(): void {
    this.workerService.getAllStramMachines().subscribe((response) => {
      this.steamMachines = response;
    });
  }

  update(steamMachine: SteamMachine) {
    this.modalRef = this.modalService.open(UpdateMachineModalComponent, { data: { machine: steamMachine }
    });
  }

  callRepairman(steamMachineId: number) {
    this.workerService.callRepairman(steamMachineId);
  }

  failureHistory(steamMachineId: number) {
    this.modalRef = this.modalService.open(FailureHistoryModalComponent, { data: { machineId: steamMachineId }
    });
  }

}
