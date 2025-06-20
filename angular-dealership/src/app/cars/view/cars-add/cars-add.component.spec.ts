import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarsAddComponent } from './cars-add.component';

describe('CarsAddComponent', () => {
  let component: CarsAddComponent;
  let fixture: ComponentFixture<CarsAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarsAddComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarsAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
