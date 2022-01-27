import { Definition } from './../../../../core/models/definition.model';
import { DictionaryResponse } from './../../../../core/models/dictionary-response.model';
import { Observable } from 'rxjs';
import { ApiDictionaryService } from './../../../../core/services/api-dictionary.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-word-definition-page',
  templateUrl: './word-definition-page.component.html',
  styleUrls: ['./word-definition-page.component.scss']
})
export class WordDefinitionPageComponent implements OnInit {

  definitions: Array<DictionaryResponse>;
  initialDefinition: DictionaryResponse;
  initialSynonyms: Array<string>;
  searchedWord: string;

  constructor(
    private apiDictionaryService: ApiDictionaryService,
    private route: ActivatedRoute

  ) { }

  ngOnInit(): void {
    this.searchedWord = this.route.snapshot.paramMap.get("word");

    this.apiDictionaryService.getWordDefinition(this.searchedWord)
      .subscribe(
        (response: Array<DictionaryResponse>) => {
          this.initialDefinition = response[0];
          this.initialSynonyms = response[0].meanings[0].definitions[0].synonyms
            .slice(0, 3);
          this.definitions = response;
        }
      );

     
  }

  pronouncePronunciation() {
    let audio = new Audio();
    audio.src = this.initialDefinition.phonetics[0].audio;
    audio.load();
    audio.play();
  }

  


}
