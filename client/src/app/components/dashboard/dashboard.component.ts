import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSelectionList } from '@angular/material';

import { FilterService } from '../../services/filter.service';
import { AccomodationService } from '../../services/accomodation.service';
import { Filter } from '../../models/filter';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public terms = [];
  public filter: Filter;
  public searchForm: FormGroup;

  public sortBy = [
    { name: 'Price', value: 'PRICE' },
    { name: 'Category', value: 'CATEGORY' },
    { name: 'Rating', value: 'RATING' }
  ];
  public order = [
    { name: 'Ascending', value: 'ASC' },
    { name: 'Descending', value: 'DESC' },
  ];

  constructor(private filterService: FilterService,
              private fb: FormBuilder,
              private accomodationService: AccomodationService) { }

  @ViewChild('services') services: MatSelectionList;
  @ViewChild('types') types: MatSelectionList;
  @ViewChild('categories') categories: MatSelectionList;

  ngOnInit() {
    this.filterService.getSearchFilter().subscribe(
      filter => this.filter = filter
    );

    this.accomodationService.getAccomodations()
      .subscribe(terms => this.terms = terms);

    this.searchForm = this.fb.group({
      city: [null, Validators.required],
      country: [null, Validators.required],
      capacity: [null, Validators.required],
      startDate: [(new Date()).toISOString(), Validators.required],
      endDate: [(new Date()).toISOString(), Validators.required],
      sortBy: 'PRICE',
      orderBy: 'ASC'
    });
  }

  sumbit() {
    const services = this.services.selectedOptions.selected.map(t => t.value).join();
    const types = this.types.selectedOptions.selected.map(t => t.value).join();
    const categories = this.categories.selectedOptions.selected.map(t => t.value).join();

    if (this.searchForm.valid) {
      this.accomodationService.searchAccomodations(this.searchForm.value, services, types, categories)
        .subscribe(terms => this.terms = terms);
    }
  }

}
