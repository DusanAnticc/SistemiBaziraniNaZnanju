import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckMachinesComponent } from './check-machines.component';

describe('CheckMachinesComponent', () => {
  let component: CheckMachinesComponent;
  let fixture: ComponentFixture<CheckMachinesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckMachinesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckMachinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
