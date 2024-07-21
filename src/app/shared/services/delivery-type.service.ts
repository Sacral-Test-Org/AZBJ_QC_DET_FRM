import { Injectable } from '@angular/core';

export interface DeliveryType {
  code: string;
  description: string;
}

@Injectable({
  providedIn: 'root'
})
export class DeliveryTypeService {
  constructor() {}

  getDeliveryTypes(): DeliveryType[] {
    return [
      { code: 'I', description: 'Immediate' },
      { code: 'S', description: 'Scheduled' }
    ];
  }
}
