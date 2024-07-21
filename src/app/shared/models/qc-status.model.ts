export class QCStatus {
  policyNumber: string;
  qcStatus: string;
  errorMessage: string;
  contractId: string;
  descType: string;
  opusValue: string;
  correctFlag: string;
  insUser: string;
  insDate: Date;
  flg: string;
  errStatus: string;
  flg1: string;
  flg2: string;
  flg3: string;
  flg4: string;
  flg5: string;
  flg6: string;

  constructor(
    policyNumber: string,
    qcStatus: string,
    errorMessage: string,
    contractId: string,
    descType: string,
    opusValue: string,
    correctFlag: string,
    insUser: string,
    insDate: Date,
    flg: string,
    errStatus: string,
    flg1: string,
    flg2: string,
    flg3: string,
    flg4: string,
    flg5: string,
    flg6: string
  ) {
    this.policyNumber = policyNumber;
    this.qcStatus = qcStatus;
    this.errorMessage = errorMessage;
    this.contractId = contractId;
    this.descType = descType;
    this.opusValue = opusValue;
    this.correctFlag = correctFlag;
    this.insUser = insUser;
    this.insDate = insDate;
    this.flg = flg;
    this.errStatus = errStatus;
    this.flg1 = flg1;
    this.flg2 = flg2;
    this.flg3 = flg3;
    this.flg4 = flg4;
    this.flg5 = flg5;
    this.flg6 = flg6;
  }
}