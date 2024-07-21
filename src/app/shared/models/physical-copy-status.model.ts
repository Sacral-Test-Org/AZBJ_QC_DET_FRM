export class PhysicalCopyStatusModel {
  policyNumber: string;
  physicalCopyStatus: 'Y' | 'N';

  constructor(policyNumber: string, physicalCopyStatus: 'Y' | 'N') {
    this.policyNumber = policyNumber;
    this.physicalCopyStatus = physicalCopyStatus;
  }
}