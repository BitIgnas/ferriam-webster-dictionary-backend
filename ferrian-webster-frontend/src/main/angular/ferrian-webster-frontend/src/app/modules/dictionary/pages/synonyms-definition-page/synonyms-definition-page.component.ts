import { DictionaryResponse } from './../../../../core/models/dictionary-response.model';
import { ApiDictionaryService } from './../../../../core/services/api-dictionary.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-synonyms-definition-page',
  templateUrl: './synonyms-definition-page.component.html',
  styleUrls: ['./synonyms-definition-page.component.scss']
})
export class SynonymsDefinitionPageComponent implements OnInit {

  word: string;
  wordOrigin: string;
  wordSynonyms: Array<string> = []

  constructor(
    private route: ActivatedRoute,
    private dictionaryService: ApiDictionaryService
  ) { }

  ngOnInit(): void {
    this.word = this.route.snapshot.paramMap.get("word");

    this.dictionaryService.getWordDefinition(this.word)
      .subscribe((data: Array<DictionaryResponse>) => {
        this.wordOrigin = data[0].origin;
      })

    this.dictionaryService.getWordSynonyms(this.word)
      .subscribe((data: Array<string>) => {
        this.wordSynonyms = data;
      })
  }



}
