import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PhysicalCopyStatusModel } from 'src/app/shared/models/physical-copy-status.model';

@Injectable({
  providedIn: 'root'
})
export class PhysicalCopyStatusService {
  private apiUrl = 'http://your-api-url.com/api/physical-copy-status';

  constructor(private http: HttpClient) {}

  updatePhysicalCopyStatus(status: PhysicalCopyStatusModel): Observable<any> {
    if (status.physicalCopyStatus !== 'Y' && status.physicalCopyStatus !== 'N') {
      throw new Error('Choose any one of the above options.');
    }
    return this.http.put(`${this.apiUrl}/update`, status);
  }
}
