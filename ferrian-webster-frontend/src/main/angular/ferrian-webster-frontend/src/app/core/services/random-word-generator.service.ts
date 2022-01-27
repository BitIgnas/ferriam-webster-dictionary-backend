import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RandomWordGeneratorService {

  constructor(
    private httpClient: HttpClient
  ) { }

  private readonly baseUrl = environment.baseUrl; 

  public getRandomWord() {
    return this.httpClient.get(`${this.baseUrl}/api/v2/random-word/`, {responseType: 'text'});
  }
}
