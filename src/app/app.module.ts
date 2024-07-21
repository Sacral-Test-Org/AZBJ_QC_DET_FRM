import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { QCCorrectionComponent } from 'src/app/features/qc-correction/qc-correction.component';
import { QCService } from 'src/app/features/qc-correction/qc-correction.service';
import { RidersDetailsComponent } from 'src/app/features/riders-details/riders-details.component';
import { RidersDetailsService } from 'src/app/features/riders-details/riders-details.service';
import { PrePrintQcComponent } from 'src/app/features/pre-print-qc/pre-print-qc.component';
import { PrePrintQcService } from 'src/app/features/pre-print-qc/pre-print-qc.service';
import { FundDetailsComponent } from 'src/app/features/fund-details/fund-details.component';
import { FundDetailsService } from 'src/app/features/fund-details/fund-details.service';
import { FundManagementComponent } from 'src/app/features/fund-management/fund-management.component';
import { FundManagementService } from 'src/app/features/fund-management/fund-management.service';
import { ReprintOptionComponent } from 'src/app/features/reprint-option/reprint-option.component';
import { PhysicalCopyStatusComponent } from 'src/app/features/physical-copy-status/physical-copy-status.component';
import { PhysicalCopyStatusService } from 'src/app/features/physical-copy-status/physical-copy-status.service';
import { NomineeManagementComponent } from 'src/app/features/nominee-management/nominee-management.component';
import { QCNomineeSelectionComponent } from 'src/app/features/qc-nominee-selection/qc-nominee-selection.component';
import { PolicySearchComponent } from 'src/app/features/policy-search/policy-search.component';
import { PolicySearchService } from 'src/app/features/policy-search/policy-search.service';
import { AuthenticationComponent } from 'src/app/features/authentication/authentication.component';
import { DispatchDetailsComponent } from 'src/app/features/dispatch-details/dispatch-details.component';
import { DispatchDetailsService } from 'src/app/features/dispatch-details/dispatch-details.service';
import { VendorSelectionComponent } from 'src/app/features/vendor-selection/vendor-selection.component';
import { VendorSelectionService } from 'src/app/features/vendor-selection/vendor-selection.service';
import { NomineeUpdateComponent } from 'src/app/features/nominee-update/nominee-update.component';
import { UWCommentsComponent } from 'src/app/features/uw-comments/uw-comments.component';

@NgModule({
  declarations: [
    AppComponent,
    QCCorrectionComponent,
    RidersDetailsComponent,
    PrePrintQcComponent,
    FundDetailsComponent,
    FundManagementComponent,
    ReprintOptionComponent,
    PhysicalCopyStatusComponent,
    NomineeManagementComponent,
    QCNomineeSelectionComponent,
    PolicySearchComponent,
    AuthenticationComponent,
    DispatchDetailsComponent,
    VendorSelectionComponent,
    NomineeUpdateComponent,
    UWCommentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    QCService,
    RidersDetailsService,
    PrePrintQcService,
    FundDetailsService,
    FundManagementService,
    PhysicalCopyStatusService,
    PolicySearchService,
    DispatchDetailsService,
    VendorSelectionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
