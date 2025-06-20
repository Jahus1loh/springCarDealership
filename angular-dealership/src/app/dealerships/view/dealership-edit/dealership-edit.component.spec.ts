import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DealershipEditComponent } from './dealership-edit.component';

describe('DealershipEditComponent', () => {
  let component: DealershipEditComponent;
  let fixture: ComponentFixture<DealershipEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DealershipEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DealershipEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
