import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeSectionBoxesComponent } from './home-section-boxes.component';

describe('HomeSectionBoxesComponent', () => {
  let component: HomeSectionBoxesComponent;
  let fixture: ComponentFixture<HomeSectionBoxesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeSectionBoxesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeSectionBoxesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
