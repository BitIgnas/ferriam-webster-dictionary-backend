import { Component, OnInit } from '@angular/core';
declare var jQuery: any;

@Component({
  selector: 'app-text-translator-page',
  templateUrl: './text-translator-page.component.html',
  styleUrls: ['./text-translator-page.component.scss']
})
export class TextTranslatorPageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
      $('.dropdown-el').click(function(e) {
        e.preventDefault();
        e.stopPropagation();
      $(this).toggleClass('expanded');
      $('#'+$(e.target).attr('for')).prop('checked',true);

      });

      $(document).click(function() {
      $('.dropdown-el').removeClass('expanded');
      });
  }

}
