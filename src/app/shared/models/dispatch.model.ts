export class Dispatch {
  SHIP_NO: string;
  AWB_NO: string;
  DEL_TYPE: string = 'I';
  VENDOR: string;
  DES_TYPE: string = 'CUST';
  PICK_REQ_NO: string;
  PR_REF: string;
  CONSIGNEE_NAME: string;
  CON_ADD1: string;
  CON_ADD2: string;
  CON_ADD3: string;
  CON_CITY: string;
  CON_STATE: string;
  DES_PIN: string;
  WT: string;
  GM: string = 'Grm';
  VEN_CODE: string;

  constructor(init?: Partial<Dispatch>) {
    Object.assign(this, init);
  }
}