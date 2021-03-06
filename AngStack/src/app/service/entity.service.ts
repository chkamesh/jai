import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Entity } from '../interfaces/entity';


@Injectable({
  providedIn: 'root'
})
export class EntityService {
  baseUrl = environment.baseUrl;


  constructor(private http: HttpClient) { }

  public getEntities(id: string) {
    console.log(this.baseUrl);
    return this.http.get<Entity>(this.baseUrl + "/" + id);
  }

  public saveEntitiy(entity: Entity) {
    console.log(this.baseUrl);
    return this.http.post<Entity>(this.baseUrl, entity);
  }
}
