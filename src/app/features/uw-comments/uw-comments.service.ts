import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UWComment } from './uw-comment.model';
import { UserService } from 'src/app/shared/services/user.service';
import { UserProfile } from 'src/app/shared/models/user-profile.model';

@Injectable({
  providedIn: 'root'
})
export class UWCommentsService {
  private baseUrl = 'http://your-backend-api-url';

  constructor(private httpClient: HttpClient, private userService: UserService) {}

  getComments(policyRef: string): Observable<UWComment[]> {
    const url = `${this.baseUrl}/comments?policyRef=${policyRef}`;
    return this.httpClient.get<UWComment[]>(url);
  }

  updateComments(comments: UWComment[]): Observable<void> {
    const url = `${this.baseUrl}/comments/update`;
    return this.httpClient.post<void>(url, comments);
  }

  getCurrentUserProfile(): UserProfile {
    return this.userService.getCurrentUserProfile();
  }
}