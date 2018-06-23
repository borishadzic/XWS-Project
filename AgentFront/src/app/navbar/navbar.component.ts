import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints, BreakpointState } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isHandset: Observable<BreakpointState> = this.breakpointObserver.observe(Breakpoints.Handset);
  constructor(private breakpointObserver: BreakpointObserver, private http: HttpClient, private snackBar: MatSnackBar) {}

  ngOnInit() {
  }

  onSync(){
    this.http.get('http://localhost:8081/accomodations/sync').subscribe(
      () =>{
        this.snackBar.open('Data synced with server','Close',{
          duration:2000
        })
        window.location.reload();
      }
    );
  }

}
