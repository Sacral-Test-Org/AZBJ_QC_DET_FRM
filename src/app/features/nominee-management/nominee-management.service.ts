import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Nominee } from 'src/app/shared/models/nominee.model';

@Injectable({
  providedIn: 'root'
})
export class NomineeManagementService {
  private apiUrl = 'http://your-api-url/nominees';

  constructor(private http: HttpClient) {}

  getNomineeData(): Observable<Nominee[]> {
    return this.http.get<Nominee[]>(this.apiUrl);
  }

  saveNomineeData(nominee: Nominee): Observable<void> {
    return this.http.post<void>(this.apiUrl, nominee);
  }
}
