import { RefreshService } from './../../../core/services/refresh.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.scss']
})
export class SearchBarComponent implements OnInit {
  searchTerm: string = "";

  constructor(
    private activatedRouter: ActivatedRoute,
    private router: Router,
    private refreshService: RefreshService
  ) { }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(
      (params) => {
        if(params['word']) {
          this.searchTerm = params['word'];
        }
      },
      tap(() => {
        this.refreshService.refresh();
      })
    )
  }

  searchDefinition() {
    this.router
      .routeReuseStrategy
      .shouldReuseRoute = function () {
        return false;
      };

    this.router.navigateByUrl(`/dictionary/${this.searchTerm}`)
      .then(
        (worked) => {
        
        },
        (error) => {
        debugger;
        }
    );
    
  }
}


