import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationModel } from 'src/app/shared/models/authentication.model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private apiUrl = 'http://your-backend-api-url/authenticate';

  constructor(private http: HttpClient) {}

  authenticate(authData: AuthenticationModel): Observable<any> {
    return this.http.post<any>(this.apiUrl, authData);
  }

  validateCredentials(supervisorID: string, password: string): Observable<boolean> {
    const authData: AuthenticationModel = { supervisorID, password };
    return this.http.post<boolean>(`${this.apiUrl}/validate`, authData);
  }
}
