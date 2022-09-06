import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { GuestService } from '../../services/guest.service';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.scss']
})
export class PayComponent implements OnInit {

  user: any;

  constructor(
    private guestService: GuestService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.user = this.authService.getCurrentUser();
  }

  pay() {
    if (this.user != null) {
      this.guestService.pay(this.user.id);
      this.user.owes = 0;
      window.location.reload();
    }
  }

}
