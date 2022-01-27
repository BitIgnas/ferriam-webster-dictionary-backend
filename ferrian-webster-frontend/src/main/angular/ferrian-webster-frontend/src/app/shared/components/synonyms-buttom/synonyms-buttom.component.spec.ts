import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SynonymsButtomComponent } from './synonyms-buttom.component';

describe('SynonymsButtomComponent', () => {
  let component: SynonymsButtomComponent;
  let fixture: ComponentFixture<SynonymsButtomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SynonymsButtomComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SynonymsButtomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
