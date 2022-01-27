import { RandomWordGeneratorService } from './../../../core/services/random-word-generator.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-word-of-the-day-box',
  templateUrl: './word-of-the-day-box.component.html',
  styleUrls: ['./word-of-the-day-box.component.scss']
})
export class WordOfTheDayBoxComponent implements OnInit {
  generatedWord: string;
  currentDate: Date;

  constructor(private randomWordService: RandomWordGeneratorService) {
    this.currentDate = new Date();
  }

  ngOnInit(): void {
    this.randomWordService.getRandomWord()
      .subscribe((response: string) => {
        this.generatedWord = response;
      })
  }

}
