import { Component, OnInit } from '@angular/core';
import { ReprintOptionService } from './reprint-option.service';

@Component({
  selector: 'app-reprint-option',
  templateUrl: './reprint-option.component.html',
  styleUrls: ['./reprint-option.component.css']
})
export class ReprintOptionComponent implements OnInit {
  reprintOption: string = 'X';

  constructor(private reprintOptionService: ReprintOptionService) { }

  ngOnInit(): void {
    this.reprintOption = 'X';
  }

  onOkButtonClick(): void {
    // Logic to handle the Ok button click
    console.log('Ok button clicked with reprint option:', this.reprintOption);
    // Potentially call a service method or emit an event
  }

  onRadioButtonChange(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    this.reprintOption = inputElement.value;
    console.log('Reprint option changed to:', this.reprintOption);
  }

  handleReprintOptionChange(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    this.reprintOption = inputElement.value;
    console.log('Reprint option changed to:', this.reprintOption);
  }
}
