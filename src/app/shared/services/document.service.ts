import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Document } from '../models/document.model';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {
  private apiUrl = 'http://localhost:8080/api/documents';

  constructor(private http: HttpClient) {}

  getDocumentPath(policyRef: string): Observable<Document> {
    const url = `${this.apiUrl}/${policyRef}`;
    return this.http.get<Document>(url);
  }
}
