import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NomineeUpdateDTO } from 'src/app/shared/models/nominee-update.model';
import { Nominee } from 'src/app/shared/models/nominee.model';

@Injectable({
  providedIn: 'root'
})
export class NomineeUpdateService {
  private baseUrl = 'api/nominee';

  constructor(private http: HttpClient) {}

  getNomineeDetails(policyRef: String): Observable<Nominee> {
    return this.http.get<Nominee>(`${this.baseUrl}/details/${policyRef}`);
  }

  updateNomineeDetails(nomineeUpdateDTO: NomineeUpdateDTO): Observable<String> {
    return this.http.post<String>(`${this.baseUrl}/update`, nomineeUpdateDTO);
  }
}
