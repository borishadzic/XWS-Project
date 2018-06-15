import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  cards = [
    {
      id: 2,
      startDate: '2018-06-14',
      endDate: '2018-06-27',
      price: 550,
      accomodation: {
        id: 1,
        name: 'Sheraton',
        country: 'Srbija',
        city: 'Novi Sad',
        address: 'Lozionicka 12',
        accomodationType: 'apartment',
        additionalService: [ 'Parking', 'Wifi', 'Breakfast' ],
        images: [
          'https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg?cs=srgb&dl=daylight-environment-forest-459225.jpg&fm=jpg',
          'https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?cs=srgb&dl=beach-exotic-holiday-248797.jpg&fm=jpg'
        ]
      }
    },
    {
      id: 2,
      startDate: '2018-06-14',
      endDate: '2018-06-27',
      price: 550,
      accomodation: {
        id: 1,
        name: 'Sheraton',
        country: 'Srbija',
        city: 'Novi Sad',
        address: 'Lozionicka 12',
        accomodationType: 'apartment',
        additionalService: [ 'Parking', 'Wifi', 'Breakfast' ],
        images: [
          'https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg?cs=srgb&dl=daylight-environment-forest-459225.jpg&fm=jpg',
          'https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?cs=srgb&dl=beach-exotic-holiday-248797.jpg&fm=jpg'
        ]
      }
    },
    {
      id: 2,
      startDate: '2018-06-14',
      endDate: '2018-06-27',
      price: 550,
      accomodation: {
        id: 1,
        name: 'Sheraton',
        country: 'Srbija',
        city: 'Novi Sad',
        address: 'Lozionicka 12',
        accomodationType: 'apartment',
        additionalService: [ 'Parking', 'Wifi', 'Breakfast' ],
        images: [
          'https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg?cs=srgb&dl=daylight-environment-forest-459225.jpg&fm=jpg',
          'https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?cs=srgb&dl=beach-exotic-holiday-248797.jpg&fm=jpg'
        ]
      }
    },
    {
      id: 2,
      startDate: '2018-06-14',
      endDate: '2018-06-27',
      price: 550,
      accomodation: {
        id: 1,
        name: 'Sheraton',
        country: 'Srbija',
        city: 'Novi Sad',
        address: 'Lozionicka 12',
        accomodationType: 'apartment',
        additionalService: [ 'Parking', 'Wifi', 'Breakfast' ],
        images: [
          'https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg?cs=srgb&dl=daylight-environment-forest-459225.jpg&fm=jpg',
          'https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?cs=srgb&dl=beach-exotic-holiday-248797.jpg&fm=jpg'
        ]
      }
    }
  ];

}
