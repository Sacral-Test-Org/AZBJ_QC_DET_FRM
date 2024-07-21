import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PrePrintQcModel } from 'src/app/shared/models/pre-print-qc.model';

@Injectable({
  providedIn: 'root'
})
export class PrePrintQcService {
  private apiUrl = 'http://your-api-url.com/pre-print-qc';

  constructor(private http: HttpClient) { }

  getPrePrintQcData(): Observable<PrePrintQcModel> {
    return this.http.get<PrePrintQcModel>(this.apiUrl);
  }
}
