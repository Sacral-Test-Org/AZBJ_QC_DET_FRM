import { Component } from '@angular/core';
import { VendorSelectionService } from './vendor-selection.service';
import { Vendor } from '../../shared/models/vendor.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-vendor-selection',
  templateUrl: './vendor-selection.component.html',
  styleUrls: ['./vendor-selection.component.css']
})
export class VendorSelectionComponent {
  vendors: Vendor[] = [];
  selectedVendor: Vendor | null = null;

  constructor(private vendorSelectionService: VendorSelectionService) {}

  onVendorFieldDoubleClick(): void {
    this.vendorSelectionService.fetchVendors().subscribe((vendors: Vendor[]) => {
      this.vendors = vendors;
      // Logic to display the vendors in a modal or dropdown
    });
  }

  onVendorSelect(vendor: Vendor): void {
    this.selectedVendor = vendor;
    // Logic to populate the selected vendor's information in the vendor field
  }
}
