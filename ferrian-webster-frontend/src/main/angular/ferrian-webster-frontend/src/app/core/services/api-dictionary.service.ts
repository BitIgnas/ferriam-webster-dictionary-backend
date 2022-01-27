import { DictionaryResponse } from './../models/dictionary-response.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiDictionaryService {

  constructor(
    private httpClient: HttpClient
  ) { }

  private readonly baseUrl = environment.baseUrl;

  public getWordDefinition(word: string): Observable<DictionaryResponse[]> {
    return this.httpClient.get<DictionaryResponse[]>(`${this.baseUrl}/api/v2/word/entry/${word}`);
  }

  public getWordSynonyms(word: string): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.baseUrl}/api/v2/word/entry/${word}/synonyms`)
  }

}
