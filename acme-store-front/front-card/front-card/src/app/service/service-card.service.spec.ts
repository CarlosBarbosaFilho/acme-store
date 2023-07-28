import { TestBed } from '@angular/core/testing';

import { ServiceCardService } from './service-card.service';

describe('ServiceCardService', () => {
  let service: ServiceCardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceCardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
