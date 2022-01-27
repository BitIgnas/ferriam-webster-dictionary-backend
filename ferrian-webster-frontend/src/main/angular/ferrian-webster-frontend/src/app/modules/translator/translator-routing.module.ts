import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TextTranslatorPageComponent } from './pages/text-translator-page/text-translator-page.component';

const routes: Routes = [
  { path: '', component: TextTranslatorPageComponent },
  { path: ':word', component: TextTranslatorPageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TranslatorRoutingModule { }
