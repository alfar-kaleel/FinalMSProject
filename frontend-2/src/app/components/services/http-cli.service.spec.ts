import { TestBed } from '@angular/core/testing';

import { HttpCliService } from './http-cli.service';

describe('HttpCliService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpCliService = TestBed.get(HttpCliService);
    expect(service).toBeTruthy();
  });
});
