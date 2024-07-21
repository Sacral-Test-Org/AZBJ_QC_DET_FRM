import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Dispatch } from 'src/app/shared/models/dispatch.model';

@Injectable({
  providedIn: 'root'
})
export class DispatchDetailsService {
  private apiUrl = 'http://your-api-url.com'; // Replace with your actual API URL

  constructor(private http: HttpClient) {}

  saveDispatchDetails(dispatchDetails: Dispatch): Observable<any> {
    const url = `${this.apiUrl}/saveDispatchDetails`;
    return this.http.post<any>(url, dispatchDetails);
  }

  getGMFieldValues(): string[] {
    return ['Grm', 'Kg', 'Lbs'];
  }

  validateAndSaveShipmentDetails(dispatch: Dispatch): Observable<any> {
    if (!dispatch.SHIP_NO || !dispatch.AWB_NO || !dispatch.VENDOR || !dispatch.WT) {
      throw new Error('Shipment number, AWB number, vendor, and weight fields are required.');
    }
    const url = `${this.apiUrl}/validateAndSaveShipmentDetails`;
    return this.http.post<any>(url, dispatch);
  }
}
