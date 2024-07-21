import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Enrichment } from '../models/enrichment.model';
import { catchError } from 'rxjs/operators';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class EnrichmentService {
  private apiUrl = 'http://your-api-url.com/api/enrichment';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  getEnrichmentDetails(applicationNumber: string): Observable<Enrichment> {
    const url = `${this.apiUrl}/${applicationNumber}`;
    this.logger.debug('Fetching enrichment details for application number:', applicationNumber);
    return this.http.get<Enrichment>(url).pipe(
      catchError(error => {
        this.logger.error('Error fetching enrichment details:', error);
        throw error;
      })
    );
  }
}
