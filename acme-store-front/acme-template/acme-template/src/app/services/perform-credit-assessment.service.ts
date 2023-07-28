import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, config } from 'rxjs';

import { CardsAvailable } from '../model/cards_available';
import { ClientData } from '../model/client-data';
import { API_PERFORM_CREDIT_ASSESSMENT } from '../config/api.config';
import { ClientDataRequest } from '../model/client_data';

@Injectable({
  providedIn: 'root'
})
export class PerformCreditAssessmentService {

  constructor(private _http: HttpClient) { }


  carryOutEvaluation(data: ClientDataRequest): Observable<CardsAvailable[]> {
     return this._http.post<CardsAvailable[]>(`${API_PERFORM_CREDIT_ASSESSMENT.baseURL}api/v1/rater-credit-customer/evaluate-customer`, data);
  }
  
}
