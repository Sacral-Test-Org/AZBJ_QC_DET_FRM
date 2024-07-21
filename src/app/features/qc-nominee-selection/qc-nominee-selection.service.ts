import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QCNomineeSelectionService {
  constructor() {}

  getDefaultValue(): string {
    return 'N';
  }
}
