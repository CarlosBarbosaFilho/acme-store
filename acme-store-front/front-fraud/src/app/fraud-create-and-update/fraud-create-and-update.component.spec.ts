import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FraudCreateAndUpdateComponent } from './fraud-create-and-update.component';

describe('FraudCreateAndUpdateComponent', () => {
  let component: FraudCreateAndUpdateComponent;
  let fixture: ComponentFixture<FraudCreateAndUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FraudCreateAndUpdateComponent]
    });
    fixture = TestBed.createComponent(FraudCreateAndUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
