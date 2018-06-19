import { Component, OnInit } from '@angular/core';

import { ReservationService } from '../../services/reservation.service';
import { MatSnackBar, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  public dataSource = new MatTableDataSource<any>();

  constructor(private reservationService: ReservationService,
              private snackBack: MatSnackBar) { }

  ngOnInit() {
    this.reservationService.getReservations()
      .subscribe(reservations => this.dataSource.data = reservations);
  }

  onCancelReservation(id, index) {
    this.reservationService.cancelReservation(id).subscribe(
      () => {
        const reservations = this.dataSource.data;
        reservations.splice(index, 1);
        this.dataSource.data = reservations;
        this.snackBack.open('Reservation canceled', 'Close', {
          duration: 2000
        });
      },
      error => this.snackBack.open(error.error.message, 'Close', {
        duration: 2000
      })
    );
  }

}
