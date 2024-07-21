import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fund } from 'src/app/shared/models/fund.model';

@Injectable({
  providedIn: 'root'
})
export class FundManagementService {
  private baseUrl = 'http://your-api-url.com/api/funds';

  constructor(private http: HttpClient) {}

  insertFund(fund: Fund): Observable<Fund> {
    return this.http.post<Fund>(`${this.baseUrl}`, fund);
  }

  updateFund(fund: Fund): Observable<Fund> {
    return this.http.put<Fund>(`${this.baseUrl}/${fund.id}`, fund);
  }
}
