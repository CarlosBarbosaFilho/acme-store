import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientCreateAndUpdateComponent } from './client-create-and-update.component';

describe('ClientCreateAndUpdateComponent', () => {
  let component: ClientCreateAndUpdateComponent;
  let fixture: ComponentFixture<ClientCreateAndUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClientCreateAndUpdateComponent]
    });
    fixture = TestBed.createComponent(ClientCreateAndUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
