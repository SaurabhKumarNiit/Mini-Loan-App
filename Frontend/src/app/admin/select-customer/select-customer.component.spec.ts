import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectCustomerComponent } from './select-customer.component';

describe('SelectCustomerComponent', () => {
  let component: SelectCustomerComponent;
  let fixture: ComponentFixture<SelectCustomerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SelectCustomerComponent]
    });
    fixture = TestBed.createComponent(SelectCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
