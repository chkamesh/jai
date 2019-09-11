import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ServerComponent } from './components/server/server.component';
import { EntityUpdateComponent } from './components/entity/entity-update/entity-update.component';
import { PropertyComponent } from './components/property/property.component';
import { EntityCreateComponent } from './components/entity/entity-create/entity-create.component';
import { DataTypeComponent } from './components/data-type/data-type.component';
import { EntityComponent } from './components/entity/entity.component';
import { EntityDeleteComponent } from './components/entity/entity-delete/entity-delete.component';
import { PropertyCreateComponent } from './components/property/property-create/property-create.component';

const routes: Routes = [

  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'server', component: ServerComponent },
  { path: 'dataType', component: DataTypeComponent },
  {
    path: 'entity', component: EntityComponent,
    children: [
      { path: 'create', component: EntityCreateComponent },
      { path: 'update', component: EntityUpdateComponent },
      { path: 'delete', component: EntityDeleteComponent }
    ]
  },
  {
    path: 'property', component: PropertyComponent, data: { title: 'jai' },
    children: [{ path: 'create', component: PropertyCreateComponent }]
  }
];


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
