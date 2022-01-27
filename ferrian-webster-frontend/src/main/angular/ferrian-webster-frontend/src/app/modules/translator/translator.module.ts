import { SharedModule } from 'src/app/shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TranslatorRoutingModule } from './translator-routing.module';
import { TextTranslatorPageComponent } from './pages/text-translator-page/text-translator-page.component';


@NgModule({
  declarations: [
    TextTranslatorPageComponent
  ],
  imports: [
    CommonModule,
    TranslatorRoutingModule,
    SharedModule
  ]
})
export class TranslatorModule { }
