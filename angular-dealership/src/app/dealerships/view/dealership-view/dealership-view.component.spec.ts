import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DealershipViewComponent } from './dealership-view.component';

describe('DealershipViewComponent', () => {
  let component: DealershipViewComponent;
  let fixture: ComponentFixture<DealershipViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DealershipViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DealershipViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
