import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WordOfTheDayBoxComponent } from './word-of-the-day-box.component';

describe('WordOfTheDayBoxComponent', () => {
  let component: WordOfTheDayBoxComponent;
  let fixture: ComponentFixture<WordOfTheDayBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WordOfTheDayBoxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WordOfTheDayBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
