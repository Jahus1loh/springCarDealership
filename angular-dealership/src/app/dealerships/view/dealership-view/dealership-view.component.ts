import { Component, OnInit, signal } from '@angular/core';
import { Dealership } from '../../model/dealership';
import { DealershipService } from '../../service/dealership.service';
import { ActivatedRoute, RouterModule, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CarService } from '../../../cars/service/car.service';
import { Car } from '../../../cars/model/car';
import { Cars } from '../../../cars/model/cars';
import { v4 as uuidv4} from 'uuid';


@Component({
  selector: 'app-dealership-view',
  imports: [RouterModule, CommonModule],
  templateUrl: './dealership-view.component.html',
  styleUrls: ['./dealership-view.component.css']
})
export class DealershipViewComponent implements OnInit {

  uuid: string | undefined;
  dealership: Dealership | undefined;
  dealershipID!: string;
  carItems = signal<Car[]>([]);

  constructor(
    private service: DealershipService,
    private route: ActivatedRoute,
    private router: Router,
    private carService: CarService,
  ) {}

  ngOnInit() {
    this.dealershipID = this.route.snapshot.paramMap.get('dealershipID')!;
    this.route.params.subscribe(params => {
      this.service.getDealership(params['dealershipID'])
        .subscribe(dealership => {
          this.dealership = dealership;
          this.loadCars();
        });
    });
  }

  loadCars(): void {
    this.carService.getCars(this.dealershipID)
      .subscribe((response: Cars) => {
        if (response && response.cars) {
          this.carItems.set(response.cars);
        } else {
          console.log('No cars found for this dealership');
        }
      });
  }

  generateUUIDAndNavigate() {
    this.uuid = uuidv4();
    this.router.navigate(['/dealerships', this.dealershipID, 'cars', this.uuid, 'create']);
  }

  onDelete(car: Car): void {
    if (this.dealershipID && car.id) {
      this.carService.deleteCar(this.dealershipID, car.id).subscribe(() => this.ngOnInit());
    }
  }
}
