import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { MatDialog } from '@angular/material';
import { CommentsDialogComponent } from '../../comments-dialog/comments-dialog.component';

@Component({
  selector: 'app-accomodation-item',
  templateUrl: './accomodation-item.component.html',
  styleUrls: ['./accomodation-item.component.css']
})
export class AccomodationItemComponent implements OnInit {

  @Input() public term: any;
  @Input() public isAuthenticated = false;
  @Output() public reserve = new EventEmitter<number>();

  constructor(private matDialog: MatDialog) { }

  ngOnInit() {
  }

  onOpenComments(id: number) {
    this.matDialog.open(CommentsDialogComponent, {
      height: '550px',
      width: '700px',
      data: id
    });
  }

}
