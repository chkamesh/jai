import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-banner',
    templateUrl: './banner.component.html',
    styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {
   title = 'AngStack';

    constructor() {
        console.log("constructor");
        this.title = 'Ang Stack';
    }

    ngOnInit() {
        console.log("ngOnInit");
        this.title='Ang Stack.';
    }
}
