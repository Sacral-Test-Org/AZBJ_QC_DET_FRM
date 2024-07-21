export interface ControlUpdateRequest {
  ci: string;
  flg: number;
}

export interface SkipApplicationRequest {
  policyRef: string;
  blockFlag: string;
  blockReason: string;
  delinkDate: Date;
  delinkUser: string;
  blockComments: string;
}