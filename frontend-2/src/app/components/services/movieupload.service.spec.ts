import { TestBed } from '@angular/core/testing';

import { MovieuploadService } from './movieupload.service';

describe('MovieuploadService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MovieuploadService = TestBed.get(MovieuploadService);
    expect(service).toBeTruthy();
  });
});
