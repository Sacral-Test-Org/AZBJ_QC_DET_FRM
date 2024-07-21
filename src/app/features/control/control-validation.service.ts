import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, switchMap } from 'rxjs/operators';
import { BeneficiaryDetailsDTO } from 'src/app/shared/models/control.model';

@Injectable({
  providedIn: 'root'
})
export class ControlValidationService {
  private apiUrl = 'http://your-api-url';

  constructor(private http: HttpClient) {}

  validatePolicyReference(policyRef: string): boolean {
    if (policyRef.length > 10 && policyRef.startsWith('101')) {
      policyRef = policyRef.slice(-10);
    }
    return policyRef.length === 10;
  }

  processPolicyReference(policyRef: string): Observable<BeneficiaryDetailsDTO> {
    if (!this.validatePolicyReference(policyRef)) {
      throw new Error('Invalid policy reference number');
    }

    return this.http.get<{ QC_status: string }>(`${this.apiUrl}/check-lock-status/${policyRef}`).pipe(
      switchMap(response => {
        if (response.QC_status === 'Y') {
          throw new Error('Policy is already locked');
        }
        return this.http.post(`${this.apiUrl}/lock-policy`, { policyRef });
      }),
      switchMap(() => this.http.get<BeneficiaryDetailsDTO>(`${this.apiUrl}/beneficiary-details/${policyRef}`)),
      catchError(err => {
        console.error(err);
        return of({ benAppDob: null, benName: null, benAppRelation: null, appointeeGender: null });
      })
    );
  }
}
