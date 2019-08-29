import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ServerComponent } from './components/server/server.component';

const routes: Routes = [

    { path: '', redirectTo: '/AngStack', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'server', component: ServerComponent, data: { title: 'jai' } }
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
