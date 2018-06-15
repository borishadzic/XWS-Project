import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators, FormControl, FormArray } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-new-accomodation',
  templateUrl: './new-accomodation.component.html',
  styleUrls: ['./new-accomodation.component.css']
})
export class NewAccomodationComponent implements OnInit {

  public form: FormGroup;
  public services = [];
  public types;
  public categories;

  constructor(private fb: FormBuilder,
              private snackBar: MatSnackBar,
              private http: HttpClient) { }

  ngOnInit() {
    


    this.form = new FormGroup({
      'name': new FormControl(null,Validators.required),
      'country': new FormControl(null,Validators.required),
      'city': new FormControl(null,Validators.required),
      'address': new FormControl(null,Validators.required),
      'accomodationType': new FormControl(null,Validators.required),
      'category': new FormControl(null,Validators.required),
      'description': new FormControl(null),
      'capacity': new FormControl(null,Validators.required),
      'terms': new FormArray([]),
      'additionalServices': new FormControl([])
    });



    this.http.get('http://localhost:8081/additionalServices').subscribe(data => {
      this.services = <any>data;
      
    });

    this.http.get('http://localhost:8081/accomodationTypes').subscribe(data => {
      this.types = data;
    });

    this.http.get('http://localhost:8081/categories').subscribe(data => {
      this.categories = data;
    });
  }


  onAddTerm(){
    //const control = new FormControl(null,Validators.required);
    //(<FormArray>this.form.get('terms')).push(control);

    const group = new FormGroup({
      'startDate': new FormControl(null,Validators.required),
      'endDate': new FormControl(null,Validators.required),
      'price': new FormControl(null,Validators.required)
    });
    (<FormArray>this.form.get('terms')).push(group);
  }

  onServiceCheck(id: any,event: any){
    let niz = <number[]>this.form.get('additionalServices').value;
    if(event.checked){
      niz.push(id);
    }else{
      let index=niz.indexOf(id);
      niz.splice(index,1);
    }
  }
  
  onSubmit(){
    if(this.form.valid){
      this.http.post('http://localhost:8081/accomodations',this.form.value)
      .subscribe(
        data => console.log(data)
      );
    }

  }


  
}
