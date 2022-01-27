import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SynonymsDefinitionPageComponent } from './synonyms-definition-page.component';

describe('SynonymsDefinitionPageComponent', () => {
  let component: SynonymsDefinitionPageComponent;
  let fixture: ComponentFixture<SynonymsDefinitionPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SynonymsDefinitionPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SynonymsDefinitionPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
