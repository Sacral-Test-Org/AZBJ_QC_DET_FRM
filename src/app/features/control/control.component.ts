import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ControlService } from './control.service';
import { QCService } from '../qc-correction/qc-correction.service';

@Component({
  selector: 'app-control',
  templateUrl: './control.component.html',
  styleUrls: ['./control.component.css']
})
export class ControlComponent implements OnInit {
  reasonsOfSkip: string[] = [];
  selectedReason: string = '';

  constructor(
    private controlService: ControlService,
    private qcService: QCService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.controlService.getReasonsOfSkip().subscribe((reasons) => {
      this.reasonsOfSkip = reasons;
    });
  }

  onCheckboxChange(event: Event): void {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      this.controlService.navigateToQCBlock().subscribe(() => {
        this.iterateAndModifyRecords();
      });
    }
  }

  iterateAndModifyRecords(): void {
    this.controlService.iterateQCRecords().subscribe((records) => {
      records.forEach((record: any) => {
        if (record.ci === 'Y' && record.flg === 10) {
          record.ci = 'N';
        }
      });
    });
  }

  onReasonOfSkipChange(event: Event): void {
    const select = event.target as HTMLSelectElement;
    this.selectedReason = select.value;
    this.controlService.saveReasonOfSkip(this.selectedReason).subscribe();
  }

  onExitButtonClick(): void {
    const policyRef = 'currentPolicyRef'; // Replace with actual policy reference
    this.controlService.exitForm(policyRef).subscribe(() => {
      // Logic to exit the form without validation
    });
  }

  onSearchButtonClick(): void {
    const policyRef = 'currentPolicyRef'; // Replace with actual policy reference
    this.controlService.updateQCStatus(policyRef).subscribe(() => {
      // Logic to clear the form
    });
  }

  onResetButtonClick(): void {
    const resetRequest = { policyRef: 'currentPolicyRef' }; // Replace with actual reset request
    this.controlService.resetControlData(resetRequest).subscribe(() => {
      // Logic to clear the form and enable 'control.sub'
    });
  }

  enrichProposal(): void {
    const proposalNumber = 'proposalNumber'; // Replace with actual proposal number
    this.controlService.checkScrutinyNumber(proposalNumber).subscribe((scrutinyExists) => {
      if (scrutinyExists) {
        this.controlService.checkEnrichmentRequests(proposalNumber).subscribe((enrichmentExists) => {
          if (enrichmentExists) {
            const url = 'generatedURL'; // Replace with actual URL generation logic
            window.open(url, '_blank');
          } else {
            alert('No image has been uploaded.');
          }
        });
      } else {
        alert('No scrutiny details are available.');
      }
    });
  }

  onViewImagesButtonClick(): void {
    const applicationNo = 'applicationNo'; // Replace with actual application number
    const contractId = 'contractId'; // Replace with actual contract ID
    this.controlService.getSolutionId(applicationNo, contractId).subscribe((data) => {
      const { solutionId, parentContractId, policyRef } = data;
      console.log(`Solution ID: ${solutionId}, Parent Contract ID: ${parentContractId}, Policy Ref: ${policyRef}`);
      const url = 'generatedURL'; // Replace with actual URL generation logic
      if (url) {
        window.open(url, '_blank');
      } else {
        alert('Please check the URL');
      }
    });
  }

  handleSkipApplication(): void {
    if (!this.selectedReason) {
      alert('Please Select Reason For Skipping Application');
      return;
    }
    if (this.selectedReason === 'OTHERS' && !this.comments) { // Replace 'comments' with actual comments variable
      alert('Please Enter comments');
      return;
    }
    const skipData = {
      policyRef: 'currentPolicyRef', // Replace with actual policy reference
      reason: this.selectedReason,
      comments: 'comments' // Replace with actual comments
    };
    this.controlService.skipApplication(skipData).subscribe(() => {
      // Logic to handle after skipping the application
    });
  }

  validatePolicyReference(policyRef: string): void {
    this.controlService.validatePolicyReference(policyRef).subscribe((data) => {
      // Handle the response
    });
  }

  processPolicyReference(policyRef: string): void {
    this.controlService.processPolicyReference(policyRef).subscribe((data) => {
      // Handle the response
    });
  }

  onCheckboxCheck(event: Event): void {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      const qcUpdateRequest = { policyRef: 'currentPolicyRef' }; // Replace with actual QC update request
      this.controlService.updateQCRecords(qcUpdateRequest).subscribe(() => {
        this.router.navigate(['/qc-section']);
      });
    }
  }

  navigateToQCSection(): void {
    this.router.navigate(['/qc-section']);
  }
}