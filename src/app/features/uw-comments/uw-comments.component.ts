import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UWCommentsService } from './uw-comments.service';
import { DateService } from '../../shared/services/date.service';
import { UserService } from '../../shared/services/user.service';
import { PolicyService } from '../../shared/services/policy.service';
import { UWComment } from './uw-comment.model';

@Component({
  selector: 'app-uw-comments',
  templateUrl: './uw-comments.component.html',
  styleUrls: ['./uw-comments.component.css']
})
export class UWCommentsComponent implements OnInit {
  user_id: string;
  comments: UWComment[] = [];
  currentDate: Date;

  constructor(
    private uwCommentsService: UWCommentsService,
    private dateService: DateService,
    private userService: UserService,
    private policyService: PolicyService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.currentDate = this.dateService.getCurrentDate();
    this.userService.getCurrentUser().subscribe(user => {
      this.user_id = user.id;
      this.fetchComments();
    });
  }

  fetchComments(): void {
    this.uwCommentsService.getComments().subscribe(comments => {
      this.comments = comments;
    });
  }

  updateComments(comments: UWComment[]): void {
    this.uwCommentsService.updateComments(comments).subscribe(() => {
      this.fetchComments();
    });
  }

  handleAlertAcknowledge(): void {
    this.router.navigate(['/qc-block']);
  }

  onUWCommentsButtonClick(): void {
    this.policyService.getPolicyNumber().subscribe(policyNumber => {
      if (!policyNumber) {
        alert('Please enter a policy number.');
        return;
      }
      this.userService.getUserProfile().subscribe(userProfile => {
        this.uwCommentsService.getComments(policyNumber, userProfile).subscribe(comments => {
          if (comments.length === 0) {
            alert('No UW comments found for the policy number.');
            this.handleAlertAcknowledge();
          } else {
            this.comments = comments;
          }
        });
      });
    });
  }
}