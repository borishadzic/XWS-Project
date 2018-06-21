import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

import { ReservationService } from '../../services/reservation.service';

@Component({
  selector: 'app-rate',
  templateUrl: './rate.component.html',
  styleUrls: ['./rate.component.css']
})
export class RateComponent implements OnInit {

  form: FormGroup;

  constructor(private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) private id: number,
              private dialogRef: MatDialogRef<RateComponent>,
              private reservationService: ReservationService) { }

  ngOnInit() {
    this.form = this.fb.group({
      rating: [null, [Validators.required, Validators.min(0), Validators.max(10)]],
      comment: ''
    });
  }

  onSubmit() {
    if (this.form.valid) {
      this.reservationService.rate(this.id, this.form.value).subscribe(
        () => this.dialogRef.close(true),
        (err) => console.log(err)
      );
    }
  }

}
