export class Fund {
  fundId: string;
  fundDescription: string;
  prApportionment: number;

  constructor(fundId: string, fundDescription: string, prApportionment: number) {
    this.fundId = fundId;
    this.fundDescription = fundDescription;
    this.prApportionment = prApportionment;
  }
}