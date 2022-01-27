import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-section-boxes',
  templateUrl: './home-section-boxes.component.html',
  styleUrls: ['./home-section-boxes.component.scss']
})
export class HomeSectionBoxesComponent implements OnInit {
  isHoveredOnElement1 = false;
  isHoveredOnElement2 = false;
  isHoveredOnElement3 = false;
  isHoveredOnElement4 = false;


  constructor() { }

  ngOnInit(): void {
  }

}
