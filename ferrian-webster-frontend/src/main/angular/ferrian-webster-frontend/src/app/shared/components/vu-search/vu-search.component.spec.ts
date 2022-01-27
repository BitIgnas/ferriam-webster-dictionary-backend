import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VuSearchComponent } from './vu-search.component';

describe('VuSearchComponent', () => {
  let component: VuSearchComponent;
  let fixture: ComponentFixture<VuSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VuSearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VuSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
