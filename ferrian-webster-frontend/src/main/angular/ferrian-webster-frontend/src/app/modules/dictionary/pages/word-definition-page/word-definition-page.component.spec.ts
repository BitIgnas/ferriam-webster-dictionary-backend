import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WordDefinitionPageComponent } from './word-definition-page.component';

describe('WordDefinitionPageComponent', () => {
  let component: WordDefinitionPageComponent;
  let fixture: ComponentFixture<WordDefinitionPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WordDefinitionPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WordDefinitionPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
