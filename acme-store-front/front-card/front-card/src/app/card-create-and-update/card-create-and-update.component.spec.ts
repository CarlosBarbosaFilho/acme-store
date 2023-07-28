import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardCreateAndUpdateComponent } from './card-create-and-update.component';

describe('CardCreateAndUpdateComponent', () => {
  let component: CardCreateAndUpdateComponent;
  let fixture: ComponentFixture<CardCreateAndUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CardCreateAndUpdateComponent]
    });
    fixture = TestBed.createComponent(CardCreateAndUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
