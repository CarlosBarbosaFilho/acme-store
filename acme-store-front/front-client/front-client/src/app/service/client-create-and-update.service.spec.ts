import { TestBed } from '@angular/core/testing';

import { ClientCreateAndUpdateService } from './client-create-and-update.service';

describe('ClientCreateAndUpdateService', () => {
  let service: ClientCreateAndUpdateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClientCreateAndUpdateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
