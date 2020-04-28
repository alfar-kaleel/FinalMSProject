import { TestBed } from '@angular/core/testing';

import { BookingettingserviceService } from './bookingettingservice.service';

describe('BookingettingserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BookingettingserviceService = TestBed.get(BookingettingserviceService);
    expect(service).toBeTruthy();
  });
});
