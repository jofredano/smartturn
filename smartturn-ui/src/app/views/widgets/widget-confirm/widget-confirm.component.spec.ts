import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WidgetConfirmComponent } from './widget-confirm.component';

describe('WidgetConfirmComponent', () => {
  let component: WidgetConfirmComponent;
  let fixture: ComponentFixture<WidgetConfirmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WidgetConfirmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WidgetConfirmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
