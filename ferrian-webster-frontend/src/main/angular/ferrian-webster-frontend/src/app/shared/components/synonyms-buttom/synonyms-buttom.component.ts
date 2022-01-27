import { trigger, transition, style, animate } from '@angular/animations';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-synonyms-buttom',
  templateUrl: './synonyms-buttom.component.html',
  styleUrls: ['./synonyms-buttom.component.scss'],
  animations: [
    trigger("grow", [
      // Note the trigger name
      transition(":enter", [
        // :enter is alias to 'void => *'
        style({ height: "0", overflow: "hidden" }),
        animate(270, style({ height: "*" }))
      ]),
      transition(":leave", [
        // :leave is alias to '* => void'
        animate(270, style({ height: 0, overflow: "hidden" }))
      ])
    ])
  ]
})
export class SynonymsButtomComponent implements OnInit {
  @Input() synonyms: Array<string>;
  @Input() word: string;
  
  show = false;

  constructor() { }

  ngOnInit(): void {
    
  }



}
