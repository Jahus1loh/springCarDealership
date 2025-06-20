import { Component, OnInit } from '@angular/core';
import { DealershipService } from '../../service/dealership.service';
import { Dealerships } from '../../model/dealerships';
import { Dealership } from '../../model/dealership';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { UUIDTypes, v4 as uuidv4} from 'uuid';

@Component({
  selector: 'app-dealership-list',
  imports: [RouterModule, CommonModule],
  templateUrl: './dealership-list.component.html',
  styleUrl: './dealership-list.component.css'
})
export class DealershipListComponent implements OnInit {


  constructor(private service: DealershipService, private router: Router) {

  }

  uuid: string | undefined;
  dealerships: Dealerships | undefined;

  ngOnInit(): void {
    this.service.getDealerships().subscribe(dealerships => this.dealerships = dealerships);
  }

  onDelete(dealership: Dealership): void {
    this.service.deleteDealership(dealership.id).subscribe(() => this.ngOnInit());
  }

  generateUUIDAndNavigate() {
    this.uuid = uuidv4();
    this.router.navigate(['/dealerships', this.uuid, 'create']);
  }
}
