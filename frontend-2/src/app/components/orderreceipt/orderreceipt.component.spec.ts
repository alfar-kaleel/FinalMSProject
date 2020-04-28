import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderreceiptComponent } from './orderreceipt.component';

describe('OrderreceiptComponent', () => {
  let component: OrderreceiptComponent;
  let fixture: ComponentFixture<OrderreceiptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderreceiptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderreceiptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
