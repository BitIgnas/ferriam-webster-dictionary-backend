import { WordDefinitionPageComponent } from './pages/word-definition-page/word-definition-page.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SynonymsDefinitionPageComponent } from './pages/synonyms-definition-page/synonyms-definition-page.component';

const routes: Routes = [
  {
    path: ':word',
    component: WordDefinitionPageComponent
  },
  {
    path: ':word/synonyms',
    component: SynonymsDefinitionPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DictionaryRoutingModule { }
