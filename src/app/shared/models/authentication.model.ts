export class AuthenticationModel {
  comments: string;
  supervisorId: string;
  password: string;

  constructor(comments: string, supervisorId: string, password: string) {
    this.comments = comments;
    this.supervisorId = supervisorId.toUpperCase(); // Automatically convert to uppercase
    this.password = password;
  }
}