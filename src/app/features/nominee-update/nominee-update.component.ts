import { Component, OnInit } from '@angular/core';
import { NomineeUpdateService } from './nominee-update.service';
import { Nominee } from './nominee.model';
import { NomineeUpdateDTO } from './nominee-update.dto';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-nominee-update',
  templateUrl: './nominee-update.component.html',
  styleUrls: ['./nominee-update.component.css']
})
export class NomineeUpdateComponent implements OnInit {
  nominee: Nominee;
  policyReference: string = 'some-policy-ref'; // This should be dynamically set based on the context

  constructor(private nomineeUpdateService: NomineeUpdateService, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.getNomineeDetails();
  }

  getNomineeDetails(): void {
    this.nomineeUpdateService.getNomineeDetails(this.policyReference).subscribe(
      (data: Nominee) => {
        if (data) {
          this.nominee = data;
        } else {
          alert('Nominee Detail Not Found');
        }
      },
      (error) => {
        this.logger.error('Error fetching nominee details', error);
        alert('Nominee Detail Not Found');
      }
    );
  }

  updateNominee(): void {
    if (confirm('Sure, want to update Nominee Name?')) {
      const newNomineeName = prompt('Enter new nominee name:', this.nominee.name);
      if (newNomineeName && newNomineeName !== this.nominee.name) {
        const updateDTO: NomineeUpdateDTO = {
          policyReference: this.policyReference,
          oldNomineeName: this.nominee.name,
          newNomineeName: newNomineeName
        };
        this.nomineeUpdateService.updateNomineeDetails(updateDTO).subscribe(
          (response: string) => {
            this.logger.info('Nominee Name updated successfully');
            alert('Nominee Name updated successfully');
            this.getNomineeDetails(); // Refresh the details
          },
          (error) => {
            this.logger.error('Error updating nominee details', error);
            alert('Error updating nominee details');
          }
        );
      } else {
        alert('No changes made to the nominee name.');
      }
    }
  }
}
