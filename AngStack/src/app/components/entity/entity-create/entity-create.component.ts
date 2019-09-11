import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-entity-create',
  templateUrl: './entity-create.component.html',
  styleUrls: ['./entity-create.component.css']
})
export class EntityCreateComponent implements OnInit {
  entityForm = new FormGroup({
    entityName: new FormControl(''),
    entityDesc: new FormControl(''),
    isMaster: new FormControl(false),
    viewName: new FormControl('..')
  });

  /* entityForm = new FormGroup({
     entityName: new FormControl('entity Name')
   });*/
  constructor() {
    console.log('in Constructor');
  }

  ngOnInit() {
    console.log('init');
  }

}
