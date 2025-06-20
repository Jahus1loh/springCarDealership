import { Component, OnInit } from '@angular/core';
import { Dealership } from '../../model/dealership';
import { DealershipForm } from '../../model/dealership-form';
import { DealershipService } from '../../service/dealership.service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-dealership-edit',
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './dealership-edit.component.html',
  styleUrl: './dealership-edit.component.css'
})
export class DealershipEditComponent implements OnInit {

  uuid: string | undefined;

  dealership: Dealership | undefined;

  original: DealershipForm | undefined;

  constructor(
    private dealershipService: DealershipService,
    private route: ActivatedRoute,
    private router: Router
  ) {

  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.dealershipService.getDealership(params['dealershipID'])
        .subscribe(dealership => {
          this.uuid = dealership.id;
          this.dealership = {
            id: dealership.id,
            name: dealership.name,
            location: dealership.location,
            cars: dealership.cars
          };
          this.original = {...this.dealership};
        })
    });
  }

  onSubmit(): void {
    this.dealershipService.putDealership(this.uuid!, this.dealership!)
    .subscribe(() => this.router.navigate(['/dealerships']));
  }

}
