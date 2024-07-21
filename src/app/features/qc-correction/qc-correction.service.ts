import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QC } from 'src/app/shared/models/qc.model';

@Injectable({
  providedIn: 'root'
})
export class QCCorrectionService {
  private apiUrl = 'http://localhost:8080/api/qc';

  constructor(private http: HttpClient) {}

  getQCData(): Observable<QC[]> {
    return this.http.get<QC[]>(`${this.apiUrl}/data`);
  }

  validateRadioButtonSelection(selection: string, flags: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/validate-selection`, { selection, flags });
  }

  fetchAndUpdateRecords(): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update-records`, {});
  }

  iterateAndUpdateQCRecords(): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/iterate-update-records`, {});
  }
}
