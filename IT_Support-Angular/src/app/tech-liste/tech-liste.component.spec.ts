import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TechListeComponent } from './tech-liste.component';

describe('TechListeComponent', () => {
  let component: TechListeComponent;
  let fixture: ComponentFixture<TechListeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TechListeComponent]
    });
    fixture = TestBed.createComponent(TechListeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
