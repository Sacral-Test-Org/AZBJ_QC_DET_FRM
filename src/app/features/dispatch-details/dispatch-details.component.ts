import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DispatchDetailsService } from './dispatch-details.service';
import { Dispatch } from 'src/app/shared/models/dispatch.model';

@Component({
  selector: 'app-dispatch-details',
  templateUrl: './dispatch-details.component.html',
  styleUrls: ['./dispatch-details.component.css']
})
export class DispatchDetailsComponent implements OnInit {
  dispatchForm: FormGroup;
  dispatchTypes = ['CUST', 'OTHER'];
  deliveryTypes = ['I', 'II'];
  gmUnits = ['Grm', 'Kg', 'Lb'];

  constructor(private fb: FormBuilder, private dispatchService: DispatchDetailsService) { }

  ngOnInit(): void {
    this.dispatchForm = this.fb.group({
      ship_no: ['', Validators.required],
      awb_no: ['', Validators.required],
      del_type: ['I', Validators.required],
      vendor: ['', Validators.required],
      des_type: ['CUST', Validators.required],
      pick_req_no: ['', Validators.required],
      pr_ref: [{ value: '', disabled: true }],
      consignee_name: [{ value: '', disabled: true }],
      con_add1: [{ value: '', disabled: true }],
      con_add2: [{ value: '', disabled: true }],
      con_add3: [{ value: '', disabled: true }],
      con_city: [{ value: '', disabled: true }],
      con_state: [{ value: '', disabled: true }],
      des_pin: [{ value: '', disabled: true }],
      wt: ['', Validators.required],
      gm: ['Grm', Validators.required],
      ven_code: [{ value: '', disabled: true }]
    });
  }

  saveDispatchDetails(): void {
    if (this.dispatchForm.valid) {
      const dispatchDetails: Dispatch = this.dispatchForm.getRawValue();
      this.dispatchService.saveDispatchDetails(dispatchDetails).subscribe(
        response => {
          alert('Dispatch details saved successfully.');
          this.clearForm();
        },
        error => {
          alert('Error saving dispatch details.');
        }
      );
    } else {
      alert('Please fill all required fields.');
    }
  }

  onDispatchTypeChange(event: Event): void {
    const selectedType = (event.target as HTMLSelectElement).value;
    this.dispatchForm.patchValue({ des_type: selectedType });
  }

  onDeliveryTypeChange(event: Event): void {
    const selectedType = (event.target as HTMLSelectElement).value;
    this.dispatchForm.patchValue({ del_type: selectedType });
  }

  validateAndSaveShipmentDetails(): void {
    if (this.dispatchForm.valid) {
      const dispatchDetails: Dispatch = this.dispatchForm.getRawValue();
      this.dispatchService.validateAndSaveShipmentDetails(dispatchDetails).subscribe(
        response => {
          if (response.success) {
            alert('Shipment dispatched successfully.');
            this.clearForm();
          } else {
            alert('Shipment number already dispatched.');
          }
        },
        error => {
          alert('Error dispatching shipment.');
        }
      );
    } else {
      alert('Please fill all required fields.');
    }
  }

  clearForm(): void {
    this.dispatchForm.reset({
      del_type: 'I',
      des_type: 'CUST',
      gm: 'Grm'
    });
  }
}
