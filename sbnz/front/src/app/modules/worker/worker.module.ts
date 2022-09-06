import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { WorkerRoutes } from './worker.routes';
import { MachinesComponent } from './components/machines/machines.component';
import { CheckMachinesComponent } from './components/check-machines/check-machines.component';
import { UpdateMachineModalComponent } from './modals/update-machine-modal/update-machine-modal.component';

@NgModule({
  declarations: [
    MachinesComponent,
    CheckMachinesComponent,
    UpdateMachineModalComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule.forChild(WorkerRoutes)
  ],
  entryComponents: [
    UpdateMachineModalComponent
  ]
})
export class WorkerModule { }
