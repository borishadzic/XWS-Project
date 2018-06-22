import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MAT_DIALOG_DATA } from '@angular/material';
import { Inject } from '@angular/core';

@Component({
  selector: 'app-comment-dialog',
  templateUrl: './comment-dialog.component.html',
  styleUrls: ['./comment-dialog.component.css']
})
export class CommentDialogComponent implements OnInit {
  public comments;

  constructor(private http: HttpClient, @Inject(MAT_DIALOG_DATA) private data: number) { }

  ngOnInit() {
    this.http.get('http://localhost:8081/accomodations/'+this.data+'/comments').subscribe(data => {
      this.comments = data;
  });


  }
}
