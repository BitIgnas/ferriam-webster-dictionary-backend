import { RouterModule } from '@angular/router';
import { VuSearchComponent } from './components/vu-search/vu-search.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBarComponent } from './components/search-bar/search-bar.component';
import { WordOfTheDayBoxComponent } from './components/word-of-the-day-box/word-of-the-day-box.component';
import { RegistrationWindowComponent } from './components/registration-window/registration-window.component';
import { HomeSectionBoxesComponent } from './components/home-section-boxes/home-section-boxes.component';
import { FormsModule } from '@angular/forms';
import { DefinitionListComponent } from './components/definition-list/definition-list.component';
import { SynonymsButtomComponent } from './components/synonyms-buttom/synonyms-buttom.component';



@NgModule({
  declarations: [
    SearchBarComponent,
    WordOfTheDayBoxComponent,
    RegistrationWindowComponent,
    HomeSectionBoxesComponent,
    VuSearchComponent,
    DefinitionListComponent,
    SynonymsButtomComponent,
    
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    SearchBarComponent,
    WordOfTheDayBoxComponent,
    RegistrationWindowComponent,
    HomeSectionBoxesComponent,
    VuSearchComponent,
    DefinitionListComponent,
    SynonymsButtomComponent
  ]
})
export class SharedModule { }
