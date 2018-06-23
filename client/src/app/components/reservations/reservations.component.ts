import { Component, OnInit } from '@angular/core';
import { MatSnackBar, MatTableDataSource, MatDialog } from '@angular/material';
import { trigger, state, style, transition, animate } from '@angular/animations';

import { ReservationService } from '../../services/reservation.service';
import { MessagesDialogComponent } from '../messages-dialog/messages-dialog.component';
import { RateComponent } from '../rate/rate.component';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css'],
  animations: [
    trigger('reservations', [
      transition('void => *', [
        style({ opacity: 0, transform: 'translateX(-200px)' }),
        animate('1s ease')
      ])
    ]),
    trigger('actions', [
      transition('void => *', [
        style({ opacity: 0, transform: 'translateX(200px)' }),
        animate('0.75s ease')
      ])
    ])
  ]
})
export class ReservationsComponent implements OnInit {

  public dataSource = new MatTableDataSource<any>();

  constructor(private reservationService: ReservationService,
              private snackBack: MatSnackBar,
              private dialog: MatDialog) { }

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

  onRate(id: number, index: number) {
    const dialog = this.dialog.open(RateComponent, {
      height: '325px',
      width: '550px',
      data: id
    });

    dialog.afterClosed().subscribe(result => {
      if (result) {
        this.dataSource.data[index].canRate = false;
        this.snackBack.open('Rating has been submited!', 'Close', {
          duration: 2000
        });
      }
    });
  }

  onOpenMessages(id: number) {
    this.dialog.open(MessagesDialogComponent, {
      height: '80%',
      width: '80%',
      data: id
    });
  }

}
