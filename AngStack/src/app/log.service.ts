import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class LogService {
    i = 0;

    constructor() {
        this.i++;
        console.log("value::" + this.i);  // {first: 'Nancy', last: 'Drew'}
    }
    display(){
        console.log("value in display::" + this.i);  // {first: 'Nancy', last: 'Drew'}

    }
}
