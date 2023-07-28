import { API_CONFIG } from './../config/api.config';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Credentials } from '../model/credentials';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private _http: HttpClient) { }

  loingIn(credentials: Credentials) {
      return this._http.post(`${API_CONFIG.baseURL}v1/login`, credentials, {
      observe: 'response',
      responseType: 'text'
    })
  }
}
