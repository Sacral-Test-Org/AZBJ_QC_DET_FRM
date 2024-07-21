import { Injectable } from '@angular/core';
import { ControlService } from './control.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ControlCheckboxService {
  constructor(private controlService: ControlService) {}

  handleCheckboxChange(event: Event): void {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      this.updateRecords().subscribe();
    }
  }

  updateRecords(): Observable<any> {
    return this.controlService.updateQCRecords();
  }
}
