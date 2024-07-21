export class Policy {
  policyRefNumber: string;
  dateOfProposal: Date;
  policyStatus: string;
  placeOfDeath: string;
  causeOfDeath: string;
  dateOfInformation: Date;
  docketReceivedOn: Date;
  allRequiredReceivedOn: Date;
  ensuredTo: string;
  verifiedBy: string;
  followedBy: string;
  deathClaimStartDate: Date;
  assignment: string;
  reserves: number;
  sumAtRisk: number;
  revisedSumAssured: number;

  constructor(
    policyRefNumber: string,
    dateOfProposal: Date,
    policyStatus: string,
    placeOfDeath: string,
    causeOfDeath: string,
    dateOfInformation: Date,
    docketReceivedOn: Date,
    allRequiredReceivedOn: Date,
    ensuredTo: string,
    verifiedBy: string,
    followedBy: string,
    deathClaimStartDate: Date,
    assignment: string,
    reserves: number,
    sumAtRisk: number,
    revisedSumAssured: number
  ) {
    this.policyRefNumber = policyRefNumber;
    this.dateOfProposal = dateOfProposal;
    this.policyStatus = policyStatus;
    this.placeOfDeath = placeOfDeath;
    this.causeOfDeath = causeOfDeath;
    this.dateOfInformation = dateOfInformation;
    this.docketReceivedOn = docketReceivedOn;
    this.allRequiredReceivedOn = allRequiredReceivedOn;
    this.ensuredTo = ensuredTo;
    this.verifiedBy = verifiedBy;
    this.followedBy = followedBy;
    this.deathClaimStartDate = deathClaimStartDate;
    this.assignment = assignment;
    this.reserves = reserves;
    this.sumAtRisk = sumAtRisk;
    this.revisedSumAssured = revisedSumAssured;
  }
}