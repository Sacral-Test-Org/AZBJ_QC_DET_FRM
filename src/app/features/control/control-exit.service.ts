import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { UserService } from '../../shared/services/user.service';
import { PolicyService } from '../../shared/services/policy.service';
import { UserProfile } from '../../shared/models/user-profile.model';
import { Comment } from '../../shared/models/comment.model';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class ControlExitService {
  constructor(
    private router: Router,
    private userService: UserService,
    private policyService: PolicyService,
    private logger: NGXLogger
  ) {}

  exitToQC(): void {
    this.userService.fetchUserProfile().pipe(
      map((userProfile: UserProfile) => {
        this.handleUserProfile(userProfile);
        return userProfile;
      }),
      catchError((error) => {
        this.logger.error('Error fetching user profile', error);
        alert('Error fetching user profile');
        throw error;
      })
    ).subscribe((userProfile: UserProfile) => {
      const policyNumber = this.getPolicyNumber();
      this.policyService.fetchComments(policyNumber).pipe(
        map((comments: Comment[]) => {
          if (comments.length === 0) {
            alert('No comments found for the given policy number');
          } else {
            this.displayComments(comments);
          }
        }),
        catchError((error) => {
          this.logger.error('Error fetching comments', error);
          alert('Error fetching comments');
          throw error;
        })
      ).subscribe();
    });
    this.router.navigate(['/qc']);
  }

  private handleUserProfile(userProfile: UserProfile): void {
    // Logic to handle user profile and set visibility settings
    if (userProfile.role !== 'requiredRole') {
      this.hideCertainFields();
    }
  }

  private getPolicyNumber(): string {
    // Logic to get the current policy number
    return 'somePolicyNumber';
  }

  private displayComments(comments: Comment[]): void {
    // Logic to display comments
    console.log('Displaying comments:', comments);
  }

  private hideCertainFields(): void {
    // Logic to hide certain fields based on user profile
    console.log('Hiding certain fields based on user profile');
  }
}