import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CarService } from '../../service/car.service';
import { Car } from '../../model/car';

@Component({
  selector: 'app-cars-view',
  imports: [RouterModule, CommonModule],
  templateUrl: './cars-view.component.html',
  styleUrls: ['./cars-view.component.css']
})
export class CarsViewComponent implements OnInit {

  car: Car | undefined;
  dealershipUuid: string | undefined;
  carUuid: string | undefined;        

  constructor(private service: CarService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.dealershipUuid = this.route.parent?.snapshot.paramMap.get('dealershipID')!;
    this.carUuid = this.route.snapshot.paramMap.get('carID')!;

    if (this.dealershipUuid && this.carUuid) {
      this.service.getCar(this.dealershipUuid, this.carUuid).subscribe(car => {
        this.car = car;
      });
    } else {
      console.error('Dealership UUID or Car UUID is missing');
    }
  }
}
