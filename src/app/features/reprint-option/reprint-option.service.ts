import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReprintOptionService {
  private reprintOptions: string[] = ['Option 1', 'Option 2', 'Option 3'];
  private currentReprintOption: string = 'X';

  constructor(private http: HttpClient) {}

  getReprintOptions(): Observable<string[]> {
    // Logic to fetch the available reprinting options
    return of(this.reprintOptions);
  }

  submitReprintOption(selectedOption: string): Observable<string> {
    // Logic to submit the selected reprinting option
    this.currentReprintOption = selectedOption;
    return of('Reprint option submitted successfully');
  }

  getReprintOption(): Observable<string> {
    // Logic to fetch the current reprint option value
    return of(this.currentReprintOption);
  }

  setReprintOption(value: string): void {
    // Logic to set the reprint option value
    this.currentReprintOption = value;
  }
}
