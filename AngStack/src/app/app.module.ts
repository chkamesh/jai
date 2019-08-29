import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ExampleAppComponent} from './example-app/example-app.component';
import {ReactiveFormsModule, FormsModule, FormGroup} from '@angular/forms';
import { UserComponent } from './user/user.component';
import { ServerComponent } from './components/server/server.component';
import { HomeComponent } from './components/home/home.component';
import { AppRoutingModule } from './app-routing.module';
import { MenuComponent } from './components/menu/menu.component';
import { BannerComponent } from './components/banner/banner.component';
import { FooterComponent } from './components/footer/footer.component';
import { EntityComponent } from './components/entity/entity.component';


@NgModule({
  declarations: [
    AppComponent,
    ExampleAppComponent,
    UserComponent,
    ServerComponent,
    HomeComponent,
    MenuComponent,
    BannerComponent,
    FooterComponent,
    EntityComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [EntityComponent]
})
export class AppModule {}
