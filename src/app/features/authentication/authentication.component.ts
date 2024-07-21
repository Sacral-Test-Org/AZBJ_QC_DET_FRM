import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/features/authentication/authentication.service';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {
  authForm: FormGroup;
  isAuthenticated: boolean = false;
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private authService: AuthenticationService) {
    this.authForm = this.fb.group({
      comments: ['', [Validators.maxLength(500)]],
      supervisorId: ['', [Validators.required, Validators.maxLength(10)]],
      password: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    // Initialize the component
  }

  handlePasswordInteraction(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    inputElement.style.borderColor = 'blue'; // Change visual attribute
  }

  handleSupervisorIDInput(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    inputElement.value = inputElement.value.toUpperCase().slice(0, 10); // Convert to uppercase and limit to 10 characters
    inputElement.style.borderColor = 'green'; // Change visual attribute
  }

  handleCommentsField(): void {
    const commentsControl = this.authForm.get('comments');
    if (commentsControl && commentsControl.value.length > 500) {
      commentsControl.setValue(commentsControl.value.slice(0, 500)); // Enforce 500-character limit
    }
  }

  authenticate(): void {
    if (this.authForm.valid) {
      const { supervisorId, password, comments } = this.authForm.value;
      this.authService.authenticate(supervisorId, password, comments).subscribe(
        response => {
          if (response.success) {
            this.isAuthenticated = true;
            this.errorMessage = '';
            // Handle successful authentication
          } else {
            this.isAuthenticated = false;
            this.errorMessage = 'Invalid credentials';
          }
        },
        error => {
          this.isAuthenticated = false;
          this.errorMessage = 'An error occurred during authentication';
        }
      );
    } else {
      this.errorMessage = 'Please fill in all required fields';
    }
  }
}
