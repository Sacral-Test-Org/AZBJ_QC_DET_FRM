import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NomineeManagementService } from './nominee-management.service';
import { Nominee } from '../../shared/models/nominee.model';

@Component({
  selector: 'app-nominee-management',
  templateUrl: './nominee-management.component.html',
  styleUrls: ['./nominee-management.component.css']
})
export class NomineeManagementComponent implements OnInit {
  nomineeForm: FormGroup;
  nominees: Nominee[] = [];

  constructor(
    private fb: FormBuilder,
    private nomineeService: NomineeManagementService
  ) {
    this.nomineeForm = this.fb.group({
      misUser: ['', [Validators.required, Validators.maxLength(50)]],
      scanDate: ['', Validators.required],
      flag: ['', Validators.required],
      insertDate: ['', Validators.required],
      flag1: ['', Validators.required],
      description: [{ value: '', disabled: true, maxLength: 200 }],
      opusValue: [{ value: '', disabled: true, maxLength: 5000 }],
      ciNominee: ['N', Validators.required]
    });
  }

  ngOnInit(): void {
    this.getNomineeData();
  }

  getNomineeData(): void {
    this.nomineeService.getNomineeData().subscribe((data: Nominee[]) => {
      this.nominees = data;
    });
  }

  saveNomineeData(): void {
    if (this.nomineeForm.valid) {
      const nominee: Nominee = this.nomineeForm.value;
      this.nomineeService.saveNomineeData(nominee).subscribe(() => {
        this.getNomineeData();
      });
    }
  }
}
