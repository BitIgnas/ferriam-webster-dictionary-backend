import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextTranslatorPageComponent } from './text-translator-page.component';

describe('TextTranslatorPageComponent', () => {
  let component: TextTranslatorPageComponent;
  let fixture: ComponentFixture<TextTranslatorPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TextTranslatorPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TextTranslatorPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
