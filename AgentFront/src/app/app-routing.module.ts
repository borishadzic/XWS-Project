import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccomodationsComponent } from 'src/app/accomodations/accomodations.component';
import { NewAccomodationComponent } from 'src/app/new-accomodation/new-accomodation.component';




const routes: Routes = [
  {path: '', redirectTo: 'accomodations', pathMatch: 'full'},
  {path: 'accomodations', component: AccomodationsComponent, pathMatch: 'full'},
  {path: 'newaccomodation', component: NewAccomodationComponent, pathMatch: 'full'}
];


@NgModule({
    imports: [
      RouterModule.forRoot(routes, {useHash: true})
    ],
    exports: [
      RouterModule
    ]
  })
  export class AppRoutingModule { }