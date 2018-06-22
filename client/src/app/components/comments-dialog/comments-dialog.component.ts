import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material';
import { AccomodationService } from '../../services/accomodation.service';

@Component({
  selector: 'app-comments-dialog',
  templateUrl: './comments-dialog.component.html',
  styleUrls: ['./comments-dialog.component.css']
})
export class CommentsDialogComponent implements OnInit {

  comments = [];

  constructor(@Inject(MAT_DIALOG_DATA) private id: number,
              private accomodationService: AccomodationService) { }

  ngOnInit() {
    this.accomodationService.getComments(this.id)
      .subscribe(comments => this.comments = comments);
  }

}
