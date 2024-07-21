import { Component, OnInit } from '@angular/core';
import { RidersDetailsService } from './riders-details.service';
import { Rider } from '../../shared/models/rider.model';

@Component({
  selector: 'app-riders-details',
  templateUrl: './riders-details.component.html',
  styleUrls: ['./riders-details.component.css']
})
export class RidersDetailsComponent implements OnInit {
  riders: Rider[] = [];
  coverDetails: Rider = { coverCode: '', sumInsured: 0, benefitTerm: 0, premiumTerm: 0 };

  constructor(private ridersDetailsService: RidersDetailsService) {}

  ngOnInit(): void {
    this.fetchRiderDetails();
  }

  fetchRiderDetails(): void {
    this.ridersDetailsService.fetchRiderDetails().subscribe((data: Rider[]) => {
      this.riders = data;
    });
  }

  displayRiderDetails(): void {
    // Logic to display rider details in a read-only format
    // This will be handled in the HTML template
  }

  saveCoverDetails(): void {
    if (this.validateCoverDetails()) {
      this.ridersDetailsService.saveCoverDetails(this.coverDetails).subscribe(response => {
        console.log('Cover details saved successfully');
      });
    }
  }

  validateCoverDetails(): boolean {
    if (!this.coverDetails.coverCode) {
      console.error('Cover code is mandatory');
      return false;
    }
    if (isNaN(this.coverDetails.sumInsured) || isNaN(this.coverDetails.benefitTerm) || isNaN(this.coverDetails.premiumTerm)) {
      console.error('Sum Insured, Benefit Term, and Premium Term must be numeric');
      return false;
    }
    return true;
  }
}
