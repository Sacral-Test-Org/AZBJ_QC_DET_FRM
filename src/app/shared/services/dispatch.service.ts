import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Dispatch } from '../models/dispatch.model';

@Injectable({
  providedIn: 'root'
})
export class DispatchService {
  private apiUrl = 'http://your-api-url.com/api/dispatch';

  constructor(private http: HttpClient) {}

  fetchDispatchDetails(contractId: string): Observable<Dispatch> {
    return this.http.get<Dispatch>(`${this.apiUrl}/details/${contractId}`);
  }

  clearDispatchDetails(): void {
    this.http.post(`${this.apiUrl}/clear`, {}).subscribe();
  }
}
