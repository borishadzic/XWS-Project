import {Component, OnInit, ViewChild, AfterViewInit} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource, MatDialog, MatSnackBar} from '@angular/material';
import { HttpClient } from '@angular/common/http';
import { MessagesDialogComponent } from 'src/app/messages-dialog/messages-dialog.component';

@Component({
  selector: 'app-terms',
  templateUrl: './terms.component.html',
  styleUrls: ['./terms.component.css']
})
export class TermsComponent implements OnInit {

  myDisplayedColumns = ['id', 'accomodation_name', 'start_date','end_date','price','visited', 'reserved' ,'inbox'];
  myDataSource: MatTableDataSource<TermData>;
  public terms;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private http: HttpClient,private dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit() {

    this.http.get('http://localhost:8081/accomodations/visited').subscribe(data => {
      this.terms = data;

      const termsD: TermData[] = [];
    for (let i = 0; i < this.terms.length; i++) { termsD.push(createTerm(this.terms[i]));}
    console.log(termsD);

    this.myDataSource = new MatTableDataSource(termsD);
    this.myDataSource.paginator = this.paginator;
    this.myDataSource.sort = this.sort;
    });

  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.myDataSource.filter = filterValue;
    if (this.myDataSource.paginator) {
      this.myDataSource.paginator.firstPage();
    }
  }

  onOpenDialog(id: number){
    
    const dialogRef = this.dialog.open(MessagesDialogComponent, 
      {
         width: '450px',
         data: id
    
      });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        
        
        
      }
    });
  }
  

  onVisitedCheck(id:any,event: any, i: any){
    this.http.get('http://localhost:8081/accomodations/'+id+'/'+event.checked,{ responseType: 'text' }).subscribe(data => {
      console.log(i);
      this.terms[i].visited = event.checked;
      const termsD: TermData[] = [];
      for (let i = 0; i < this.terms.length; i++) { termsD.push(createTerm(this.terms[i])); }
  
      this.myDataSource = new MatTableDataSource(termsD);
      this.myDataSource.paginator = this.paginator;
      this.myDataSource.sort = this.sort;
    });
  }

  onReservedCheck(id:any,event: any, i:any){
    this.http.get('http://localhost:8081/accomodations/terms/'+id+'/reserved/'+event.checked,{ responseType: 'text' }).subscribe(data => {
      this.terms[i].reserved = event.checked;
      const termsD: TermData[] = [];
      for (let i = 0; i < this.terms.length; i++) { termsD.push(createTerm(this.terms[i])); }
  
      this.myDataSource = new MatTableDataSource(termsD);
      this.myDataSource.paginator = this.paginator;
      this.myDataSource.sort = this.sort;
    },
    error => {
      this.snackBar.open('Error reserving a term, Term is already reserved by a user!!!', 'Close', {
        duration: 2000
      });
    }
  );
  }

}


function createTerm(term): TermData{
  return{
    id: term.id,
    accomodation_name: term.accomodation.name,
    start_date: term.startDate,
    end_date: term.endDate,
    price: term.price,
    visited: term.visited,
    reserved: term.reserved
  }
}


export interface TermData{
  id: number;
  accomodation_name: string;
  start_date: string;
  end_date: string;
  price: number;
  reserved : boolean;
  visited: boolean;
}
