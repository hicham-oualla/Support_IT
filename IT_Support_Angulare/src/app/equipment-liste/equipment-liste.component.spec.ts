import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipmentListeComponent } from './equipment-liste.component';

describe('EquipmentListeComponent', () => {
  let component: EquipmentListeComponent;
  let fixture: ComponentFixture<EquipmentListeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EquipmentListeComponent]
    });
    fixture = TestBed.createComponent(EquipmentListeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
