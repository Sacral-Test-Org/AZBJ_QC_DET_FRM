import { Component, OnInit } from '@angular/core';
import { PrePrintQcService } from 'src/app/features/pre-print-qc/pre-print-qc.service';
import { PrePrintQcModel } from 'src/app/shared/models/pre-print-qc.model';

@Component({
  selector: 'app-pre-print-qc',
  templateUrl: './pre-print-qc.component.html',
  styleUrls: ['./pre-print-qc.component.css']
})
export class PrePrintQcComponent implements OnInit {
  prePrintQcData: PrePrintQcModel;

  constructor(private prePrintQcService: PrePrintQcService) { }

  ngOnInit(): void {
    this.prePrintQcService.getPrePrintQcData().subscribe((data: PrePrintQcModel) => {
      this.prePrintQcData = data;
    });
  }
}
