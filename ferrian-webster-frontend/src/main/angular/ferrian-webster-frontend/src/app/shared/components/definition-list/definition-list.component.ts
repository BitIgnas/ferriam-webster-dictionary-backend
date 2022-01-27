import { DictionaryResponse } from './../../../core/models/dictionary-response.model';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-definition-list',
  templateUrl: './definition-list.component.html',
  styleUrls: ['./definition-list.component.scss']
})
export class DefinitionListComponent implements OnInit {
  @Input() definitions: Array<DictionaryResponse>;
  phonetics: Array<string> = [];

  constructor() { }

  ngOnInit(): void {
    this.definitions.shift()
    this.definitions.forEach(def => {
      this.phonetics.push(def.phonetic)
    })
    
    this.phonetics.slice(1);
    console.log(this.phonetics)
  }
}
