export class Nominee {
  misUser: string;
  scanDate: Date;
  flag: number;
  insertDate: Date;
  flag1: string;
  description: string;
  opusValue: string;
  ciNominee: string = 'N';

  constructor(
    misUser: string,
    scanDate: Date,
    flag: number,
    insertDate: Date,
    flag1: string,
    description: string,
    opusValue: string,
    ciNominee: string = 'N'
  ) {
    this.misUser = misUser;
    this.scanDate = scanDate;
    this.flag = flag;
    this.insertDate = insertDate;
    this.flag1 = flag1;
    this.description = description;
    this.opusValue = opusValue;
    this.ciNominee = ciNominee;
  }
}