import { SharedModule } from 'src/app/shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DictionaryRoutingModule } from './dictionary-routing.module';
import { WordDefinitionPageComponent } from './pages/word-definition-page/word-definition-page.component';
import { SynonymsDefinitionPageComponent } from './pages/synonyms-definition-page/synonyms-definition-page.component';


@NgModule({
  declarations: [
    WordDefinitionPageComponent,
    SynonymsDefinitionPageComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    DictionaryRoutingModule
  ]
})
export class DictionaryModule { }
