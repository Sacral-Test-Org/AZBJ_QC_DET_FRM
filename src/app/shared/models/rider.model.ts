export class Rider {
  coverCode: string;
  sumInsured: number;
  benefitTerm: number;
  premiumTerm: number;

  constructor(coverCode: string, sumInsured: number, benefitTerm: number, premiumTerm: number) {
    this.coverCode = coverCode;
    this.sumInsured = sumInsured;
    this.benefitTerm = benefitTerm;
    this.premiumTerm = premiumTerm;
  }
}
