import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoodControlComponent } from './mood-control.component';

describe('MoodControlComponent', () => {
  let component: MoodControlComponent;
  let fixture: ComponentFixture<MoodControlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoodControlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoodControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
