import { TestBed, inject } from '@angular/core/testing';

import { RateService } from './rate.service';

describe('RateService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RateService]
    });
  });

  it('should be created', inject([RateService], (service: RateService) => {
    expect(service).toBeTruthy();
  }));
});
