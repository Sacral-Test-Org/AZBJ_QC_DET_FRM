import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fund } from 'src/app/shared/models/fund.model';

@Injectable({
  providedIn: 'root'
})
export class FundDetailsService {
  private apiUrl = 'http://your-backend-api-url/fund-details';

  constructor(private http: HttpClient) {}

  fetchFundDetails(): Observable<Fund[]> {
    return this.http.get<Fund[]>(this.apiUrl);
  }
}