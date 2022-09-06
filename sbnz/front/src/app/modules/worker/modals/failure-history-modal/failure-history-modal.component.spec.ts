import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FailureHistoryModalComponent } from './failure-history-modal.component';

describe('FailureHistoryModalComponent', () => {
  let component: FailureHistoryModalComponent;
  let fixture: ComponentFixture<FailureHistoryModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FailureHistoryModalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FailureHistoryModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
