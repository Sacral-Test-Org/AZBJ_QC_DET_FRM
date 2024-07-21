import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserProfile } from '../models/user-profile.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080/api/control';

  constructor(private httpClient: HttpClient) {}

  getCurrentUser(): string {
    // Logic to return the current user
    return 'current_user'; // Placeholder for actual user retrieval logic
  }

  getCurrentUserProfile(): Observable<UserProfile> {
    // Logic to make an HTTP GET request to fetch the current user's profile and permissions
    return this.httpClient.get<UserProfile>(`${this.apiUrl}/user-profile`);
  }

  fetchUserProfile(): Observable<UserProfile> {
    // Logic to call the ControlController to fetch the current user's profile
    return this.getCurrentUserProfile();
  }

  getUserProfile(): Observable<UserProfile> {
    // Logic to make an HTTP GET request to retrieve the user's profile
    return this.httpClient.get<UserProfile>(`${this.apiUrl}/user-profile`);
  }
}
