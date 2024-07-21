export interface QCVerificationRequest {
  policyNumber: string;
  userDetails: UserDetails;
}

export interface QCVerificationResponse {
  policyNumber: string;
  qcStatus: string;
  message: string;
}

export interface UserDetails {
  userId: string;
  isBot: boolean;
}

export class QCVerificationModel {
  policyNumber: string;
  userDetails: UserDetails;
  qcStatus: string;
  message: string;

  constructor(request: QCVerificationRequest, response: QCVerificationResponse) {
    this.policyNumber = request.policyNumber;
    this.userDetails = request.userDetails;
    this.qcStatus = response.qcStatus;
    this.message = response.message;
  }
}