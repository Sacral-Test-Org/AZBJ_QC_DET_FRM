package com.azbj.qc.controller;

import com.azbj.qc.service.ControlService;
import com.azbj.qc.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/control")
public class ControlController {

    @Autowired
    private ControlService controlService;

    @PostMapping("/exit")
    public void exitForm(@RequestParam String policyRef) {
        controlService.updateRecordsAndExit(policyRef);
    }

    @PostMapping("/updateQCStatus")
    public void updateQCStatus(@RequestParam String policyRef) {
        controlService.updateQCStatus(policyRef);
    }

    @PostMapping("/reset")
    public ResponseEntity<Void> resetControl(@RequestBody ResetRequestDTO resetRequest) {
        controlService.resetControlData(resetRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateNomineeDetails")
    public ResponseEntity<String> updateNomineeDetails(@RequestBody NomineeUpdateDTO nomineeUpdateDTO) {
        return controlService.updateNomineeDetails(nomineeUpdateDTO);
    }

    @GetMapping("/checkScrutinyNumber")
    public boolean checkScrutinyNumber(@RequestParam String proposalNumber) {
        return controlService.checkScrutinyNumber(proposalNumber);
    }

    @GetMapping("/checkEnrichmentRequests")
    public boolean checkEnrichmentRequests(@RequestParam String scrutinyNumber) {
        return controlService.checkEnrichmentRequests(scrutinyNumber);
    }

    @GetMapping("/getEnrichmentDetails")
    public boolean getEnrichmentDetails(@RequestParam String applicationNumber) {
        return controlService.getEnrichmentDetails(applicationNumber);
    }

    @GetMapping("/getCustomerName")
    public String getCustomerName(@RequestParam String contractId) {
        return controlService.getCustomerName(contractId);
    }

    @PostMapping("/updateQCRecords")
    public ResponseEntity<Void> updateQCRecords(@RequestBody ControlUpdateDTO controlUpdateDTO) {
        controlService.updateQCRecords(controlUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getSolutionId")
    public ViewImagesDTO getSolutionId(@RequestParam String applicationNo, @RequestParam String contractId) {
        return controlService.getSolutionId(applicationNo, contractId);
    }

    @GetMapping("/getDispatchDetails")
    public DispatchDTO getDispatchDetails(@RequestParam String contractId) {
        return controlService.getDispatchDetails(contractId);
    }

    @PostMapping("/clearDispatchDetails")
    public void clearDispatchDetails() {
        controlService.clearDispatchDetails();
    }

    @PostMapping("/handleCheckboxChange")
    public void handleCheckboxChange() {
        controlService.iterateAndUpdateRecords();
    }

    @GetMapping("/validatePolicyReference")
    public PolicyReferenceDTO validatePolicyReference(@RequestParam String policyRef) {
        return controlService.validatePolicyReference(policyRef);
    }

    @GetMapping("/processPolicyReference")
    public BeneficiaryDetailsDTO processPolicyReference(@RequestParam String policyRef) {
        return controlService.processPolicyReference(policyRef);
    }

    @PostMapping("/skipApplication")
    public ResponseEntity<String> skipApplication(@RequestBody ControlUpdateDTO controlUpdateDTO) {
        return controlService.skipApplication(controlUpdateDTO);
    }

    @GetMapping("/getDocumentPath")
    public DocumentDTO getDocumentPath(@RequestParam String policyRef) {
        return controlService.getDocumentPath(policyRef);
    }

    @PostMapping("/submitPolicyNumberForQC")
    public QCStatusDTO submitPolicyNumberForQC(@RequestBody QCVerificationDTO qcVerificationDTO) {
        return controlService.verifyPolicyNumber(qcVerificationDTO);
    }
}