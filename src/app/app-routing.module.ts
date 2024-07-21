import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UWCommentsComponent } from './features/uw-comments/uw-comments.component';
import { QCCorrectionComponent } from './features/qc-correction/qc-correction.component';
import { RidersDetailsComponent } from './features/riders-details/riders-details.component';
import { PrePrintQcComponent } from './features/pre-print-qc/pre-print-qc.component';
import { FundDetailsComponent } from './features/fund-details/fund-details.component';
import { FundManagementComponent } from './features/fund-management/fund-management.component';
import { ReprintOptionComponent } from './features/reprint-option/reprint-option.component';
import { PhysicalCopyStatusComponent } from './features/physical-copy-status/physical-copy-status.component';
import { NomineeManagementComponent } from './features/nominee-management/nominee-management.component';
import { QCNomineeSelectionComponent } from './features/qc-nominee-selection/qc-nominee-selection.component';
import { PolicySearchComponent } from './features/policy-search/policy-search.component';
import { AuthenticationComponent } from './features/authentication/authentication.component';
import { DispatchDetailsComponent } from './features/dispatch-details/dispatch-details.component';
import { VendorSelectionComponent } from './features/vendor-selection/vendor-selection.component';
import { ControlComponent } from './features/control/control.component';

const routes: Routes = [
  { path: 'uw-comments', component: UWCommentsComponent },
  { path: 'qc-correction', component: QCCorrectionComponent },
  { path: 'riders-details', component: RidersDetailsComponent },
  { path: 'pre-print-qc', component: PrePrintQcComponent },
  { path: 'fund-details', component: FundDetailsComponent },
  { path: 'fund-management', component: FundManagementComponent },
  { path: 'reprint-option', component: ReprintOptionComponent },
  { path: 'physical-copy-status', component: PhysicalCopyStatusComponent },
  { path: 'nominee-management', component: NomineeManagementComponent },
  { path: 'qc-nominee-selection', component: QCNomineeSelectionComponent },
  { path: 'policy-search', component: PolicySearchComponent },
  { path: 'authentication', component: AuthenticationComponent },
  { path: 'dispatch-details', component: DispatchDetailsComponent },
  { path: 'vendor-selection', component: VendorSelectionComponent },
  { path: 'control', component: ControlComponent },
  { path: 'qc', component: QCCorrectionComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }