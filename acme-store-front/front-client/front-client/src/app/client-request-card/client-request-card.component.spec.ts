import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientRequestCardComponent } from './client-request-card.component';

describe('ClientRequestCardComponent', () => {
  let component: ClientRequestCardComponent;
  let fixture: ComponentFixture<ClientRequestCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClientRequestCardComponent]
    });
    fixture = TestBed.createComponent(ClientRequestCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
