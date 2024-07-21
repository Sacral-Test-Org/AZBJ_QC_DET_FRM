export class Control {
  policyRef: string;
  beneficiaryDetails: BeneficiaryDetailsDTO;
  applicationNumber: string;
  appointeeGender: string;

  constructor(policyRef: string, beneficiaryDetails: BeneficiaryDetailsDTO, applicationNumber: string, appointeeGender: string) {
    this.policyRef = policyRef;
    this.beneficiaryDetails = beneficiaryDetails;
    this.applicationNumber = applicationNumber;
    this.appointeeGender = appointeeGender;
  }
}

export class BeneficiaryDetailsDTO {
  benAppDob: string | null;
  benName: string | null;
  benAppRelation: string | null;

  constructor(benAppDob: string | null = null, benName: string | null = null, benAppRelation: string | null = null) {
    this.benAppDob = benAppDob;
    this.benName = benName;
    this.benAppRelation = benAppRelation;
  }
}