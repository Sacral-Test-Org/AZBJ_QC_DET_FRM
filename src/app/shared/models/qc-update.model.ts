export class QCUpdateRequest {
  ci: string;
  flg: number;

  constructor(ci: string, flg: number) {
    this.ci = ci;
    this.flg = flg;
  }
}