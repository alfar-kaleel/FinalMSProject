import { TestBed } from '@angular/core/testing';

import { MoviebookingloginService } from './moviebookinglogin.service';

describe('MoviebookingloginService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MoviebookingloginService = TestBed.get(MoviebookingloginService);
    expect(service).toBeTruthy();
  });
});
