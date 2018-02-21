import { HttpClient } from '@angular/common/http';
import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {User} from '../../interfaces'
import 'rxjs';

/*
  Generated class for the ProvidersUsersProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class ProvidersUsersProvider {

  constructor(public http: HttpClient) {
    console.log('Hello ProvidersUsersProvider Provider');
  }
  
  list(): Observable<User | any > {
    return this.http.get('/api/users');
  }

}
