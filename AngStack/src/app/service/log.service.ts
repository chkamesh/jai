import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LogService {
  messages: string[] = [];

  constructor(){
       this.add("1st");
  }
  add(message: string) {
    this.messages.push(message);
  }

  clear() {
    this.messages = [];
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/
