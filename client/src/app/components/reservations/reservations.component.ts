import { Component, OnInit } from '@angular/core';

import { ReservationService } from '../../services/reservation.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  public reservations = [];

  constructor(private reservationService: ReservationService) { }

  ngOnInit() {
    this.reservationService.getReservations()
      .subscribe(reservations => this.reservations = reservations);
  }

}
