import { Client } from './../model/client';
import { API_CONFIG } from './../config/api.config';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private _http: HttpClient) { }

  updateClient(client: Client, id:any): Observable<void> {
    return this._http.put<void>(`${API_CONFIG.baseURL}api/v1/clients/${id}`, client)
  }

  getClients(): Observable<Client[]> {
     return this._http.get<Client[]>(`${API_CONFIG.baseURL}api/v1/clients`);
  }

  create(client: Client): Observable<Client> {
    return this._http.post<Client>(`${API_CONFIG.baseURL}api/v1/clients`, client);
  }
  
  findById(id: any): Observable<Client> {
    return this._http.get<Client>(`${API_CONFIG.baseURL}api/v1/clients/${id}`)
  }

  deleteClient(id: any): Observable<void> {
    return this._http.delete<void>(`${API_CONFIG.baseURL}api/v1/clients/${id}`)
  }
}
