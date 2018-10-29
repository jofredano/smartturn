import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormCreateContactComponent } from './form-create-contact.component';

describe('FormCreateContactComponent', () => {
  let component: FormCreateContactComponent;
  let fixture: ComponentFixture<FormCreateContactComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormCreateContactComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormCreateContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
