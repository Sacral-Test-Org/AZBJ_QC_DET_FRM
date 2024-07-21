export class UWComment {
  policyNumber: string;
  userProfile: string;
  comment: string;
  date: Date;

  constructor(policyNumber: string, userProfile: string, comment: string, date: Date) {
    this.policyNumber = policyNumber;
    this.userProfile = userProfile;
    this.comment = comment;
    this.date = date;
  }
}