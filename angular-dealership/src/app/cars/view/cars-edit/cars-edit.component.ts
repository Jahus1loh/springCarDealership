import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Car } from '../../model/car';
import { CarService } from '../../service/car.service';

@Component({
  selector: 'app-car-edit',
  imports: [CommonModule, FormsModule],
  templateUrl: './cars-edit.component.html',
  styleUrls: ['./cars-edit.component.css']
})
export class CarsEditComponent implements OnInit {
  dealershipUuid: string | undefined;
  carUuid: string | undefined;
  car: Car = {
    id: '',
    brandName: '',
    modelName: '',
    country: '',
    productionYear: 0,
    price: 0,
    dealershipID: ''
  };
  original: Car | undefined;

  constructor(
    private carService: CarService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.dealershipUuid = this.route.parent?.snapshot.paramMap.get('dealershipID') || undefined;
    this.carUuid = this.route.snapshot.paramMap.get('carID') || undefined;
  
    console.log('Dealership UUID:', this.dealershipUuid);
    console.log('Car UUID:', this.carUuid);
  
    if (this.dealershipUuid && this.carUuid) {
      this.carService.getCar(this.dealershipUuid, this.carUuid).subscribe({
        next: (car) => {
          if (car) {
            this.car = {
              id: car.id,
              brandName: car.brandName,
              modelName: car.modelName,
              country: car.country,
              productionYear: car.productionYear,
              price: car.price,
              dealershipID: car.dealershipID
            };
            this.original = { ...this.car };
          } else {
            console.error('Car data is null or undefined');
          }
        },
        error: (err) => {
          console.error('Failed to fetch car data:', err);
        }
      });
    } else {
      console.error('Dealership UUID or Car UUID is missing!');
    }
  }
  

  onSubmit(): void {
    if (this.carUuid && this.dealershipUuid && this.car) {
      this.carService.putCar(this.dealershipUuid, this.carUuid, this.car).subscribe(() => {
        this.router.navigate([`/dealerships/${this.dealershipUuid}/cars`]);
      });
    }
  }

  resetForm(): void {
    if (this.original) {
      this.car = { ...this.original };
    }
  }
}
