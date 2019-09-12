import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ReactiveFormsModule, FormsModule, FormGroup} from '@angular/forms';
import { UserComponent } from './user/user.component';
import { ServerComponent } from './components/server/server.component';
import { HomeComponent } from './components/home/home.component';
import { AppRoutingModule } from './app-routing.module';
import { MenuComponent } from './components/menu/menu.component';
import { BannerComponent } from './components/banner/banner.component';
import { FooterComponent } from './components/footer/footer.component';
import { EntityComponent } from './components/entity/entity.component';
import { PropertyComponent } from './components/property/property.component';
import { DataTypeComponent } from './components/data-type/data-type.component';
import { EntityCreateComponent } from './components/entity/entity-create/entity-create.component';
import { EntityUpdateComponent } from './components/entity/entity-update/entity-update.component';
import { EntityDeleteComponent } from './components/entity/entity-delete/entity-delete.component';
import { PropertyCreateComponent } from './components/property/property-create/property-create.component';
import {LogService} from './service/log.service';
import { MessageComponent } from './components/message/message.component';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ServerComponent,
    HomeComponent,
    MenuComponent,
    BannerComponent,
    FooterComponent,
    EntityComponent,
    PropertyComponent,
    DataTypeComponent,
    EntityCreateComponent,
    EntityUpdateComponent,
    EntityDeleteComponent,
    PropertyCreateComponent,
    MessageComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [LogService],
  bootstrap: [AppComponent],
  exports: [EntityComponent, PropertyComponent, DataTypeComponent, EntityCreateComponent, EntityUpdateComponent,
     EntityDeleteComponent, PropertyCreateComponent, MessageComponent]
})
export class AppModule {}
