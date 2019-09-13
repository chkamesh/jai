import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { LogService } from 'src/app/service/log.service';
import { EntityService } from 'src/app/service/entity.service';
import { Entity } from 'src/app/interfaces/entity';


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
  constructor(private logService: LogService, private entityService: EntityService) {
    console.log('in Constructor');
  }

  ngOnInit() {
    console.log('init');
  }
  save() {
    this.entityService.getEntities().subscribe((data: Entity) =>   {
    // this.entityForm.entDesc:  data['entName'];
    //  textfile:  data['entDesc']
      this.logService.add(data['entName']);
  });
    //0 this.entityForm.setValue
    // this.logService.add(JSON.stringify());
    // this.logService.add(JSON.stringify(this.entityForm.getRawValue()));
  }
}
