import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { UUIDTypes, v4 as uuidv4} from 'uuid';
import { CarService } from '../../service/car.service';
import { Cars } from '../../model/cars';
import { Car } from '../../model/car';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-car-list',
  imports: [RouterModule, CommonModule],
  templateUrl: './cars-list.component.html',
  styleUrls: ['./cars-list.component.css']
})
export class CarsListComponent implements OnInit {

  dealershipUuid: string | undefined;  // Dealership UUID
  cars: Cars | undefined;

  constructor(
    private service: CarService, 
    private router: Router, 
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // Get the dealership UUID from the route params
    this.dealershipUuid = this.route.snapshot.paramMap.get('dealershipUuid')!;
    
    // Fetch cars for the dealership
    if (this.dealershipUuid) {
      this.service.getCars(this.dealershipUuid).subscribe(cars => {
        this.cars = cars;
      });
    } else {
      console.error('Dealership UUID is missing');
    }
  }

  onDelete(car: Car): void {
    if (this.dealershipUuid && car.id) {
      this.service.deleteCar(this.dealershipUuid, car.id).subscribe(() => this.ngOnInit());
    }
  }

  generateUUIDAndNavigateCars() {
    if (this.dealershipUuid) {
      const carUuid = uuidv4();
      this.router.navigate([`/dealerships/${this.dealershipUuid}/cars/${carUuid}/create`]);
    }
  }
}
