export class Enrichment {
  applicationNumber: string;
  formName: string;
  proposalNumber: string;
  customerName: string;

  constructor(applicationNumber: string, formName: string, proposalNumber: string, customerName: string) {
    this.applicationNumber = applicationNumber;
    this.formName = formName;
    this.proposalNumber = proposalNumber;
    this.customerName = customerName;
  }
}