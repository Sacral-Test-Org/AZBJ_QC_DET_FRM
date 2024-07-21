import { Component } from '@angular/core';
import { PhysicalCopyStatusService } from './physical-copy-status.service';
import { PhysicalCopyStatusModel } from '../../shared/models/physical-copy-status.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-physical-copy-status',
  templateUrl: './physical-copy-status.component.html',
  styleUrls: ['./physical-copy-status.component.css']
})
export class PhysicalCopyStatusComponent {
  physicalCopyStatus: string = '';
  policyNumber: string = '';

  constructor(private physicalCopyStatusService: PhysicalCopyStatusService, private logger: NGXLogger) {}

  onOkButtonClick(): void {
    if (this.physicalCopyStatus !== 'Y' && this.physicalCopyStatus !== 'N') {
      alert('Choose any one of the above options.');
      return;
    }

    const statusModel: PhysicalCopyStatusModel = {
      policyNumber: this.policyNumber,
      physicalCopyStatus: this.physicalCopyStatus
    };

    this.physicalCopyStatusService.updatePhysicalCopyStatus(statusModel).subscribe(
      response => {
        alert('Status updated successfully.');
        this.clearForm();
      },
      error => {
        this.logger.error('Error updating status:', error);
        alert('Data Not Updated.');
      }
    );
  }

  clearForm(): void {
    this.physicalCopyStatus = '';
    this.policyNumber = '';
    // Assuming there's an input element with id 'policyReference' to move the cursor to
    const policyRefInput = document.getElementById('policyReference') as HTMLInputElement;
    if (policyRefInput) {
      policyRefInput.focus();
    }
  }
}
