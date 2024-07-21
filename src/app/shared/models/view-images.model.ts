export class ViewImagesModel {
  solutionId: string;
  parentContractId: string;
  policyReferenceNumber: string;

  constructor(solutionId: string, parentContractId: string, policyReferenceNumber: string) {
    this.solutionId = solutionId;
    this.parentContractId = parentContractId;
    this.policyReferenceNumber = policyReferenceNumber;
  }
}