import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-qc-nominee-selection',
  templateUrl: './qc-nominee-selection.component.html',
  styleUrls: ['./qc-nominee-selection.component.css']
})
export class QCNomineeSelectionComponent implements OnInit {
  nomineeSelection: string = 'N';
  radioGroupStyles: any;

  constructor() { }

  ngOnInit(): void {
    this.initializeRadioGroup();
    this.setStyles();
  }

  initializeRadioGroup(): void {
    this.nomineeSelection = 'N';
  }

  setStyles(): void {
    this.radioGroupStyles = {
      'position': 'absolute',
      'left': '339px',
      'top': '134px',
      'width': '68px',
      'height': '14px',
      'background-color': 'gray',
      'color': 'black'
    };
  }
}
