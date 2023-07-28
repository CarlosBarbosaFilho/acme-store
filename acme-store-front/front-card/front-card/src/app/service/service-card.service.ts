import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceCardService {

  constructor(private _http: HttpClient) { }

  create(data: any): Observable<any> {
    return this._http.post("http://localhost:8082/api/v1/cards", data);
  }

  update(id:number, data: any): Observable<any> {
    return this._http.put(`http://localhost:8082/api/v1/cards/${id}`, data);
  }

  list(): Observable<any> {
    return this._http.get('http://localhost:8082/api/v1/cards');
  }

  delete(id: number): Observable<any> {
    return this._http.delete(`http://localhost:8082/api/v1/cards/${id}`);
  }

}
