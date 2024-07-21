import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FundManagementService } from './fund-management.service';
import { Fund } from '../../shared/models/fund.model';

@Component({
  selector: 'app-fund-management',
  templateUrl: './fund-management.component.html',
  styleUrls: ['./fund-management.component.css']
})
export class FundManagementComponent implements OnInit {
  fundForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private fundService: FundManagementService
  ) {}

  ngOnInit(): void {
    this.fundForm = this.fb.group({
      fundId: ['', [Validators.required, Validators.maxLength(100)]],
      fundDescription: ['', [Validators.required, Validators.maxLength(100)]],
      prApportionment: ['', [Validators.required, Validators.maxLength(100)]]
    });
  }

  insertFund(): void {
    if (this.fundForm.valid) {
      const newFund: Fund = this.fundForm.value;
      this.fundService.insertFund(newFund).subscribe(
        (response) => {
          console.log('Fund inserted successfully', response);
        },
        (error) => {
          console.error('Error inserting fund', error);
        }
      );
    }
  }

  updateFund(): void {
    if (this.fundForm.valid) {
      const updatedFund: Fund = this.fundForm.value;
      this.fundService.updateFund(updatedFund).subscribe(
        (response) => {
          console.log('Fund updated successfully', response);
        },
        (error) => {
          console.error('Error updating fund', error);
        }
      );
    }
  }
}
