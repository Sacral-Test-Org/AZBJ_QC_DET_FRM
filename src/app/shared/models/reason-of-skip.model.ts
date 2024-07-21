export class ReasonOfSkip {
  reasonId: number;
  reasonDescription: string;

  constructor(reasonId: number, reasonDescription: string) {
    this.reasonId = reasonId;
    this.reasonDescription = reasonDescription;
  }
}