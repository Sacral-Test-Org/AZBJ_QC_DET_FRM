import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vendor } from 'src/app/shared/models/vendor.model';

@Injectable({
  providedIn: 'root'
})
export class VendorSelectionService {
  private apiUrl = 'http://your-backend-api-url/vendors';

  constructor(private http: HttpClient) { }

  fetchVendors(): Observable<Vendor[]> {
    return this.http.get<Vendor[]>(this.apiUrl);
  }
}
