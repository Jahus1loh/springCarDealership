import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule} from '@angular/router';
import { CarService } from '../../service/car.service';

@Component({
  selector: 'app-car-add',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule, ReactiveFormsModule],
  templateUrl: './cars-add.component.html',
  styleUrls: ['./cars-add.component.css']
})
export class CarsAddComponent implements OnInit {
  carForm: FormGroup;
  uuid: string = '';

  constructor(
    private carService: CarService,
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder // Injected FormBuilder directly
  ) {
    // Initialize the form group
    this.carForm = this.fb.group({
      brandName: ['', Validators.required],
      modelName: ['', Validators.required],
      country: ['', Validators.required],
      price: ['', [Validators.required, Validators.pattern(/^\d+(\.\d{1,2})?$/)]], // Optional price format validation
      productionYear: ['', [Validators.required, Validators.pattern(/^\d{4}$/)]], // Validate year as 4 digits
      dealershipID: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const dealershipUuid = this.route.parent?.snapshot.paramMap.get('dealershipID');
      const carUuid = params['carID'];
      
      console.log('Dealership ID:', dealershipUuid);
      console.log('Car ID:', carUuid);
    
      if (!dealershipUuid || !carUuid) {
        console.error('Dealership ID or Car ID not found in the URL!');
        return;
      }
  
      // Set the dealership ID field in the form
      this.carForm.patchValue({
        dealershipID: dealershipUuid
      });
    });
  }
  

  resetForm(): void {
    const dealershipID = this.carForm.get('dealershipID')?.value;
    this.carForm.reset({ dealershipID });
  }

  onSubmit(): void {
    console.log('Form status:', this.carForm.status);
    console.log('Form values:', this.carForm.value);
  
    const price = +this.carForm.value.price;  // Convert price to a number
    const productionYear = +this.carForm.value.productionYear;  // Convert productionYear to a number
  
    // Retrieve dealershipUuid and carUuid from the URL parameters
    const dealershipUuid = this.route.parent?.snapshot.paramMap.get('dealershipID');
    const carUuid = this.route.snapshot.paramMap.get('carID');
  
    if (!dealershipUuid || !carUuid) {
      console.error('Dealership UUID or Car UUID is missing from the URL!');
      return;
    }
  
    // Update form values with converted numbers
    this.carForm.patchValue({
      price: price,
      productionYear: productionYear
    });
  
    if (this.carForm.valid) {
      console.log('Submitting form...');
      this.carService.addCar(
        dealershipUuid,                           // Dealership UUID from the URL
        carUuid,                                  // Car UUID from the URL
        this.carForm.value.brandName,             // Brand name
        this.carForm.value.modelName,             // Model name
        this.carForm.value.country,               // Country
        price,                                    // Price (as number)
        productionYear                            // Production year (as number)
      ).subscribe(() => {
        console.log('Car added successfully!');
        this.router.navigate(['/dealerships']);
      });
    } else {
      console.warn('Form is invalid!');
    }
  }
  


  
}
