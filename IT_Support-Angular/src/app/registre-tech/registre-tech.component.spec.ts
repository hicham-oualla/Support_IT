import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistreTechComponent } from './registre-tech.component';

describe('RegistreTechComponent', () => {
  let component: RegistreTechComponent;
  let fixture: ComponentFixture<RegistreTechComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistreTechComponent]
    });
    fixture = TestBed.createComponent(RegistreTechComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
