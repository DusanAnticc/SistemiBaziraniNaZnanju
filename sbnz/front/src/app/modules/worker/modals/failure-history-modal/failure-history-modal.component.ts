import { Component, OnInit } from '@angular/core';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { Log } from 'src/app/models/Log';
import { WorkerService } from '../../services/worker.service';

@Component({
  selector: 'app-failure-history-modal',
  templateUrl: './failure-history-modal.component.html',
  styleUrls: ['./failure-history-modal.component.scss']
})
export class FailureHistoryModalComponent implements OnInit {

  machineId: number;
  logs: Log[];

  constructor(
    public modalRef: MdbModalRef<FailureHistoryModalComponent>,
    private workerService: WorkerService
  ) { }

  ngOnInit(): void {
    this.workerService.getAllLogsForMachine(this.machineId).subscribe((response) => {
      this.logs = response;
      console.log(this.logs)
    });
  }

}
