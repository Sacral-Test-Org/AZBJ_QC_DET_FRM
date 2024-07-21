export class QC {
  FLG: number;
  DESC: string;
  OPUSVAL: string;
  CI: string;
  SCAN_DATE: Date;
  INS_DT: Date;
  FLG1: number;
  MIS_USER: string;

  constructor(
    FLG: number,
    DESC: string,
    OPUSVAL: string,
    CI: string = 'N',
    SCAN_DATE: Date,
    INS_DT: Date,
    FLG1: number,
    MIS_USER: string
  ) {
    this.FLG = FLG;
    this.DESC = DESC;
    this.OPUSVAL = OPUSVAL;
    this.CI = CI;
    this.SCAN_DATE = SCAN_DATE;
    this.INS_DT = INS_DT;
    this.FLG1 = FLG1;
    this.MIS_USER = MIS_USER;
  }
}

export class QCModel {
  selection: string;
  flags: { [key: string]: boolean };
  FLG: number;
  DESC: string;
  OPUSVAL: string;
  CI: string;
  SCAN_DATE: Date;
  INS_DT: Date;
  FLG1: number;
  MIS_USER: string;

  constructor(
    selection: string = 'N',
    flags: { [key: string]: boolean } = {},
    FLG: number,
    DESC: string,
    OPUSVAL: string,
    CI: string = 'N',
    SCAN_DATE: Date,
    INS_DT: Date,
    FLG1: number,
    MIS_USER: string
  ) {
    this.selection = selection;
    this.flags = flags;
    this.FLG = FLG;
    this.DESC = DESC;
    this.OPUSVAL = OPUSVAL;
    this.CI = CI;
    this.SCAN_DATE = SCAN_DATE;
    this.INS_DT = INS_DT;
    this.FLG1 = FLG1;
    this.MIS_USER = MIS_USER;
  }
}
