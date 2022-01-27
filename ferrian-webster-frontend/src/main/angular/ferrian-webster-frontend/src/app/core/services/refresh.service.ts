import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RefreshService {

  constructor() { }
  
  refreshNeeded = new BehaviorSubject<boolean>(true);

  getRefresh() {
    return this.refreshNeeded;
  }

  refresh() {
    this.refreshNeeded.next(true);
  }
}
