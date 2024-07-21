import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router, NavigationExtras } from '@angular/router';
import { QCService } from '../qc-correction/qc-correction.service';
import { PolicyService } from 'src/app/shared/services/policy.service';
import { DispatchService } from 'src/app/shared/services/dispatch.service';
import { ControlCheckboxService } from './control-checkbox.service';
import { ControlUpdateRequest } from 'src/app/shared/models/control-update.model';
import { ResetRequestModel } from 'src/app/shared/models/reset-request.model';
import { ViewImagesModel } from 'src/app/shared/models/view-images.model';
import { Dispatch } from 'src/app/shared/models/dispatch.model';
import { PolicyReferenceDTO } from 'src/app/shared/models/policy-reference.dto';
import { BeneficiaryDetailsDTO } from 'src/app/shared/models/beneficiary-details.dto';
import { QCUpdateRequest } from 'src/app/shared/models/qc-update.model';
import { QCVerificationModel } from 'src/app/shared/models/qc-verification.model';
import { QCStatusModel } from 'src/app/shared/models/qc-status.model';
import { Document } from 'src/app/shared/models/document.model';
import { ReasonOfSkip } from 'src/app/shared/models/reason-of-skip.model';

@Injectable({
  providedIn: 'root'
})
export class ControlService {
  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private qcService: QCService,
    private policyService: PolicyService,
    private dispatchService: DispatchService,
    private controlCheckboxService: ControlCheckboxService
  ) {}

  handleCheckboxChange(event: Event): void {
    if ((event.target as HTMLInputElement).checked) {
      this.qcService.fetchAndUpdateRecords().subscribe();
    }
  }

  getReasonsOfSkip(): Observable<string[]> {
    return this.httpClient.get<string[]>('/api/reasons-of-skip');
  }

  saveReasonOfSkip(selectedReason: string): Observable<void> {
    return this.httpClient.post<void>('/api/save-reason-of-skip', { reason: selectedReason });
  }

  navigateToQCBlock(): Observable<any> {
    const extras: NavigationExtras = { queryParams: { section: 'QC' } };
    return new Observable(observer => {
      this.router.navigate(['/qc-block'], extras).then(success => {
        observer.next(success);
        observer.complete();
      }, error => {
        observer.error(error);
      });
    });
  }

  iterateQCRecords(): Observable<any> {
    return this.httpClient.get('/api/iterate-qc-records');
  }

  updateQCStatus(policyRef: string): Observable<any> {
    return this.policyService.updateQCStatus(policyRef);
  }

  resetControlData(resetRequest: ResetRequestModel): Observable<void> {
    return this.httpClient.post<void>('/api/reset-control-data', resetRequest);
  }

  checkScrutinyNumber(proposalNumber: string): Observable<boolean> {
    return this.httpClient.get<boolean>(`/api/check-scrutiny-number/${proposalNumber}`);
  }

  checkEnrichmentRequests(scrutinyNumber: string): Observable<boolean> {
    return this.httpClient.get<boolean>(`/api/check-enrichment-requests/${scrutinyNumber}`);
  }

  getEnrichmentDetails(applicationNumber: string): Observable<boolean> {
    return this.httpClient.get<boolean>(`/api/get-enrichment-details/${applicationNumber}`);
  }

  getCustomerName(contractId: string): Observable<string> {
    return this.httpClient.get<string>(`/api/get-customer-name/${contractId}`);
  }

  updateQCRecords(controlUpdateRequest: ControlUpdateRequest): Observable<any> {
    return this.httpClient.post('/api/update-qc-records', controlUpdateRequest);
  }

  getSolutionId(applicationNo: string, contractId: string): Observable<ViewImagesModel> {
    return this.httpClient.get<ViewImagesModel>(`/api/get-solution-id/${applicationNo}/${contractId}`);
  }

  fetchDispatchDetails(contractId: string): Observable<Dispatch> {
    return this.dispatchService.fetchDispatchDetails(contractId);
  }

  clearDispatchDetails(): void {
    this.dispatchService.clearDispatchDetails();
  }

  skipApplication(skipData: object): Observable<any> {
    return this.httpClient.post('/api/skip-application', skipData);
  }

  getDocumentPath(policyRef: string): Observable<Document> {
    return this.httpClient.get<Document>(`/api/get-document-path/${policyRef}`);
  }

  validatePolicyReference(policyRef: string): Observable<PolicyReferenceDTO> {
    return this.httpClient.get<PolicyReferenceDTO>(`/api/validate-policy-reference/${policyRef}`);
  }

  processPolicyReference(policyRef: string): Observable<BeneficiaryDetailsDTO> {
    return this.httpClient.get<BeneficiaryDetailsDTO>(`/api/process-policy-reference/${policyRef}`);
  }

  verifyPolicyNumber(qcVerificationModel: QCVerificationModel): Observable<QCStatusModel> {
    return this.httpClient.post<QCStatusModel>('/api/verify-policy-number', qcVerificationModel);
  }
}
