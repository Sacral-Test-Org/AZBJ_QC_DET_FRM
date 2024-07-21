import { Component, OnInit } from '@angular/core';
import { FundDetailsService } from './fund-details.service';
import { Fund } from '../../shared/models/fund.model';

@Component({
  selector: 'app-fund-details',
  templateUrl: './fund-details.component.html',
  styleUrls: ['./fund-details.component.css']
})
export class FundDetailsComponent implements OnInit {
  funds: Fund[] = [];

  constructor(private fundDetailsService: FundDetailsService) { }

  ngOnInit(): void {
    this.fetchFundDetails();
  }

  fetchFundDetails(): void {
    this.fundDetailsService.fetchFundDetails().subscribe((data: Fund[]) => {
      this.funds = data;
    });
  }
}
