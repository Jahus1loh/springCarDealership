import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, RouterModule, Router } from '@angular/router';
import { Dealership } from '../../model/dealership';
import { DealershipService } from '../../service/dealership.service';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-dealership-add',
  imports: [CommonModule, RouterModule, FormsModule, ReactiveFormsModule],
  templateUrl: './dealership-add.component.html',
  styleUrls: ['./dealership-add.component.css']
})
export class DealershipAddComponent implements OnInit {

  dealershipForm: FormGroup;
  uuid: string = '';

  constructor(
    private dealershipService: DealershipService,
    private router: Router,
    private route: ActivatedRoute 
  ) {
    const fb = inject(FormBuilder);
    this.dealershipForm = fb.group({
      name: ["", Validators.required],
      location: ["", Validators.required]
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.uuid = params['dealershipID'];
      if (!this.uuid) {
        console.error('UUID not found in the URL!');
      }
    });
  }

  resetForm(): void {
    this.dealershipForm.reset();
  }

  onSubmit(): void {
    if (this.dealershipForm.valid && this.uuid) {
      this.dealershipService.addDealership(
        this.uuid,
        this.dealershipForm.value.name ?? "",
        this.dealershipForm.value.location ?? ""
      ).subscribe(() => {
        this.router.navigate(['/dealerships']);
      });
    }
  }
}
