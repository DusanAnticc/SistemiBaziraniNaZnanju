import { Component, OnInit } from '@angular/core';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { SteamMachine } from 'src/app/models/SteamMachine';
import { WorkerService } from '../../services/worker.service';

@Component({
  selector: 'app-update-machine-modal',
  templateUrl: './update-machine-modal.component.html',
  styleUrls: ['./update-machine-modal.component.scss']
})
export class UpdateMachineModalComponent {

  machine: SteamMachine;

  constructor(
    public modalRef: MdbModalRef<UpdateMachineModalComponent>,
    private router: Router,
    private workerService: WorkerService,
    private toastrService: ToastrService
  ) { }

  saveChanges() {
    if ((<HTMLInputElement>document.getElementById("steamValue")).value === "") {

      this.toastrService.error('Steam value field is empty!');

    } else {
      this.workerService.updateMachine(this.machine.id, Number((<HTMLInputElement>document.getElementById("steamValue")).value))
      this.modalRef.close();
      this.router.navigate(["worker/machines"]);
    }
  }

}
