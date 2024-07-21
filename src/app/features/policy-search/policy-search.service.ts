import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Policy } from 'src/app/shared/models/policy.model';

@Injectable({
  providedIn: 'root'
})
export class PolicySearchService {
  private apiUrl = '/api/policies';

  constructor(private http: HttpClient) {}

  searchPolicy(policyRefNumber: string): Observable<Policy> {
    return this.http.get<Policy>(`${this.apiUrl}/${policyRefNumber}`).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    let errorMessage = 'An unknown error occurred!';
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred.
      errorMessage = `An error occurred: ${error.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      errorMessage = `Server returned code: ${error.status}, error message is: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}
