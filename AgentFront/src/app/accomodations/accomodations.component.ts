import {Component, OnInit, ViewChild, AfterViewInit} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-accomodations',
  templateUrl: './accomodations.component.html',
  styleUrls: ['./accomodations.component.css']
})
export class AccomodationsComponent implements OnInit,AfterViewInit {
  displayedColumns = ['id', 'name', 'progress', 'color'];
  myDisplayedColumns = ['id','name','country','city','type','category','capacity'];
  dataSource: MatTableDataSource<UserData>;
  myDataSource: MatTableDataSource<AccomodationData>;
  public accomodations;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private http: HttpClient) {
    // Create 100 users
    const users: UserData[] = [];
    for (let i = 1; i <= 100; i++) { users.push(createNewUser(i)); }

    // Assign the data to the data source for the table to render
    this.dataSource = new MatTableDataSource(users);

    
  }

  ngOnInit() {
    

    this.http.get('http://localhost:8081/accomodations').subscribe(data => {
      this.accomodations = data;
      console.log(this.accomodations);

      const accomodationsD: AccomodationData[] = [];
    for (let i = 0; i < this.accomodations.length; i++) { accomodationsD.push(createAccomodation(this.accomodations[i])); }

    this.myDataSource = new MatTableDataSource(accomodationsD);
    this.myDataSource.paginator = this.paginator;
    this.myDataSource.sort = this.sort;
    console.log(this.myDataSource);
    });

    
  }

  ngAfterViewInit(){
    
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.myDataSource.filter = filterValue;
    if (this.myDataSource.paginator) {
      this.myDataSource.paginator.firstPage();
    }
  }
}

/** Builds and returns a new User. */
function createNewUser(id: number): UserData {
  const name =
      NAMES[Math.round(Math.random() * (NAMES.length - 1))] + ' ' +
      NAMES[Math.round(Math.random() * (NAMES.length - 1))].charAt(0) + '.';

  return {
    id: id.toString(),
    name: name,
    progress: Math.round(Math.random() * 100).toString(),
    color: COLORS[Math.round(Math.random() * (COLORS.length - 1))]
  };
}

function createAccomodation(acc): AccomodationData{
  return{
    id: acc.id,
    name: acc.name,
    country: acc.country,
    city: acc.city,
    type: acc.accomodationType.type,
    category: acc.category.category,
    capacity: acc.capacity
  }
}

/** Constants used to fill up our data base. */
const COLORS = ['maroon', 'red', 'orange', 'yellow', 'olive', 'green', 'purple',
  'fuchsia', 'lime', 'teal', 'aqua', 'blue', 'navy', 'black', 'gray'];
const NAMES = ['Maia', 'Asher', 'Olivia', 'Atticus', 'Amelia', 'Jack',
  'Charlotte', 'Theodore', 'Isla', 'Oliver', 'Isabella', 'Jasper',
  'Cora', 'Levi', 'Violet', 'Arthur', 'Mia', 'Thomas', 'Elizabeth'];

export interface UserData {
  id: string;
  name: string;
  progress: string;
  color: string;
}

export interface AccomodationData{
  id: string;
  name: string;
  country: string;
  city: string;
  type: string;
  category: string;
  capacity: number;
}