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
    id: new FormControl(''),
    entId: new FormControl(''),
    entName: new FormControl(''),
    entDesc: new FormControl(''),
    master: new FormControl(false),
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
  retrive() {
    this.logService.add(this.entityForm.controls['id'].value);
    this.entityService.getEntities(this.entityForm.controls['id'].value).subscribe((data: Entity) => {
      this.entityForm.patchValue(data);
      //  textfile:  data['entDesc']
      this.logService.add(JSON.stringify(data));
      this.logService.add(data['entName']);
    });
  }

  save() {
    this.logService.add(JSON.stringify(this.entityForm.value));
    this.entityService.saveEntitiy(this.entityForm.value).subscribe((data: Entity) => {
      this.entityForm.patchValue(data);
      //  textfile:  data['entDesc']
      this.logService.add(JSON.stringify(data));
      this.logService.add(data['entName']);
    });
  }
}
