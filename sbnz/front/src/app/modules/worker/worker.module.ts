import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { WorkerRoutes } from './worker.routes';
import { MachinesComponent } from './components/machines/machines.component';
import { CheckMachinesComponent } from './components/check-machines/check-machines.component';

@NgModule({
  declarations: [
    MachinesComponent,
    CheckMachinesComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule.forChild(WorkerRoutes)
  ]
})
export class WorkerModule { }
