import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarsViewComponent } from './cars-view.component';

describe('CarsViewComponent', () => {
  let component: CarsViewComponent;
  let fixture: ComponentFixture<CarsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarsViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
