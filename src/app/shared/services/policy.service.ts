import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Policy } from '../models/policy.model';
import { UWComment } from '../models/uw-comment.model';
import { QC } from '../models/qc.model';
import { QCService } from 'src/app/features/qc-correction/qc-correction.service';
import { Comment } from '../models/comment.model';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {
  private apiUrl = 'http://localhost:8080/api/policies';

  constructor(private http: HttpClient, private qcService: QCService) {}

  getPolicyDetails(proposalNumber: string): Observable<Policy> {
    return this.http.get<Policy>(`${this.apiUrl}/details/${proposalNumber}`);
  }

  getQCData(): Observable<QC[]> {
    return this.qcService.getQCData();
  }

  getPolicyComments(policyId: string): Observable<UWComment[]> {
    return this.http.get<UWComment[]>(`${this.apiUrl}/comments/${policyId}`);
  }

  updatePolicyDetails(policy: Policy): Observable<Policy> {
    return this.http.put<Policy>(`${this.apiUrl}/update`, policy);
  }

  fetchComments(policyNumber: string): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.apiUrl}/comments/fetch/${policyNumber}`);
  }

  getPolicyNumber(): Observable<string> {
    return new Observable<string>((observer) => {
      const policyNumber = localStorage.getItem('policyNumber');
      if (policyNumber) {
        observer.next(policyNumber);
      } else {
        observer.error('No policy number found');
      }
      observer.complete();
    });
  }
}
