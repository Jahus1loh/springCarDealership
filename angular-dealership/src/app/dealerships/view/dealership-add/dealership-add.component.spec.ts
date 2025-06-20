import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DealershipAddComponent } from './dealership-add.component';

describe('DealershipAddComponent', () => {
  let component: DealershipAddComponent;
  let fixture: ComponentFixture<DealershipAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DealershipAddComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DealershipAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
