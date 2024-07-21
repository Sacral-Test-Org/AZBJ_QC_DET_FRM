import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PolicySearchService } from './policy-search.service';
import { Policy } from '../../shared/models/policy.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-policy-search',
  templateUrl: './policy-search.component.html',
  styleUrls: ['./policy-search.component.css']
})
export class PolicySearchComponent {
  policyForm: FormGroup;
  policyDetails: Policy | null = null;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private policySearchService: PolicySearchService,
    private logger: NGXLogger
  ) {
    this.policyForm = this.fb.group({
      policyRefNumber: ['', Validators.required]
    });
  }

  searchPolicy(): void {
    const policyRefNumber = this.policyForm.get('policyRefNumber')?.value;
    if (policyRefNumber) {
      this.policySearchService.searchPolicy(policyRefNumber).subscribe(
        (policy: Policy) => this.handlePolicyDetails(policy),
        (error: any) => {
          this.errorMessage = 'Policy not found.';
          this.logger.error('Policy not found:', error);
        }
      );
    }
  }

  handlePolicyDetails(policy: Policy): void {
    this.policyDetails = policy;
    this.errorMessage = null;
    // Additional logic to update the UI based on policy details
    // For example, enabling/disabling fields based on QC status
    if (policy.qcPassed) {
      // Enable certain fields for further actions
    } else {
      // Disable those fields
    }
  }
}
