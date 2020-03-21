import { TestBed } from '@angular/core/testing';

import { MoviegettingService } from './moviegetting.service';

describe('MoviegettingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MoviegettingService = TestBed.get(MoviegettingService);
    expect(service).toBeTruthy();
  });
});
