import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMachineModalComponent } from './update-machine-modal.component';

describe('UpdateMachineModalComponent', () => {
  let component: UpdateMachineModalComponent;
  let fixture: ComponentFixture<UpdateMachineModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateMachineModalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateMachineModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
