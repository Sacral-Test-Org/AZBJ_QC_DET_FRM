import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Rider } from 'src/app/shared/models/rider.model';

@Injectable({
  providedIn: 'root'
})
export class RidersDetailsService {
  private apiUrl = 'http://your-backend-api-url'; // Replace with your actual API URL

  constructor(private http: HttpClient) {}

  fetchRiderDetails(): Observable<Rider[]> {
    return this.http.get<Rider[]>(`${this.apiUrl}/riders`);
  }

  saveCoverDetails(coverDetails: Rider): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/riders`, coverDetails);
  }
}
