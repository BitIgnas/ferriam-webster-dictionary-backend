import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: "/home",
    pathMatch: "full"
  },
  { 
    path: 'home',
    loadChildren: () => import('./modules/home/home.module').then(m => m.HomeModule)
  },
  {
    path: 'dictionary',
    loadChildren: () => import('./modules/dictionary/dictionary.module').then(m => m.DictionaryModule) 
  },
  {
    path: 'translator',
    loadChildren: () => import('./modules/translator/translator.module').then(m => m.TranslatorModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{
      anchorScrolling: 'enabled'
    })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
