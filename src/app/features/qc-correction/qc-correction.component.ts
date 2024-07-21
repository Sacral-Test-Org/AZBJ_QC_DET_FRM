import { Component, OnInit, HostListener } from '@angular/core';
import { QCService } from './qc-correction.service';
import { QC } from 'src/app/shared/models/qc.model';
import { UserService } from 'src/app/shared/services/user.service';
import { PolicyService } from 'src/app/shared/services/policy.service';
import { Observable } from 'rxjs';
import { UserProfile } from 'src/app/shared/models/user-profile.model';
import { Comment } from 'src/app/shared/models/comment.model';

@Component({
  selector: 'app-qc-correction',
  templateUrl: './qc-correction.component.html',
  styleUrls: ['./qc-correction.component.css']
})
export class QCCorrectionComponent implements OnInit {
  qcData: QC[] = [];
  currentRecordIndex: number = 0;
  userProfile: UserProfile | null = null;
  comments: Comment[] = [];

  constructor(
    private qcService: QCService,
    private userService: UserService,
    private policyService: PolicyService
  ) {}

  ngOnInit(): void {
    this.fetchQCData();
    this.fetchUserProfile();
    this.fetchComments('policyNumber'); // Replace 'policyNumber' with actual policy number
  }

  fetchQCData(): void {
    this.qcService.getQCData().subscribe((data: QC[]) => {
      this.qcData = data;
    });
  }

  handleRadioButtonSelection(event: Event): void {
    const target = event.target as HTMLInputElement;
    const selection = target.value;
    const flags = this.getFlags(); // Assume getFlags() returns the necessary flags

    this.qcService.validateRadioButtonSelection(selection, flags).subscribe(response => {
      if (response.alert) {
        alert(response.message);
      }
      if (response.resetFields) {
        this.resetFields();
      }
    });
  }

  navigateRecords(): void {
    if (this.currentRecordIndex >= this.qcData.length - 1) {
      this.currentRecordIndex = 0;
    } else {
      this.currentRecordIndex++;
    }
  }

  @HostListener('document:keydown', ['$event'])
  handleKeyDown(event: KeyboardEvent): void {
    if (event.key === 'ArrowDown') {
      this.navigateRecords();
    }
  }

  fetchUserProfile(): void {
    this.userService.fetchUserProfile().subscribe((profile: UserProfile) => {
      this.userProfile = profile;
      this.setVisibilitySettings();
    });
  }

  fetchComments(policyNumber: string): void {
    this.policyService.fetchComments(policyNumber).subscribe((comments: Comment[]) => {
      if (comments.length === 0) {
        alert('No comments found for the given policy number.');
      } else {
        this.comments = comments;
      }
    });
  }

  setVisibilitySettings(): void {
    if (this.userProfile && !this.userProfile.hasRequiredProfile) {
      // Hide certain fields based on user profile
    }
  }

  resetFields(): void {
    // Logic to reset certain fields to 'N'
  }

  getFlags(): object {
    // Logic to get the necessary flags
    return {};
  }
}