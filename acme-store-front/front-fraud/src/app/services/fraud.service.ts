import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FraudService {

  constructor(private _http: HttpClient) { }

  create(data: any): Observable<any> {
    return this._http.post('http://localhost:8083/api/v1/frauds',data);
  }

  list(): Observable<any> {
    return this._http.get('http://localhost:8083/api/v1/frauds');
  }

  delete(id: number): Observable<any>  {
    return this._http.delete(`http://localhost:8083/api/v1/frauds/${id}`)
  }

  active_inactive(id: number): Observable<any>  {
    return this._http.get(`http://localhost:8083/api/v1/frauds/check-fraud/${id}`)
  }

  update(id: number, data: any): Observable<any> {
    return this._http.put(`http://localhost:8083/api/v1/frauds/${id}`, data);
  }
}
