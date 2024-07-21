package com.azbj.qc.controller;

import com.azbj.qc.service.QCService;
import com.azbj.qc.dto.QCDTO;
import com.azbj.qc.model.QC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qc")
public class QCController {

    @Autowired
    private QCService qcService;

    @PostMapping("/validateSelection")
    public ResponseEntity<?> validateSelection(@RequestParam String selection, @RequestBody Object flags) {
        boolean isValid = qcService.validateRadioButtonSelection(selection, flags);
        if (isValid) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Validation failed");
        }
    }

    @PostMapping("/submitQCDetails")
    public ResponseEntity<QC> submitQCDetails(@RequestBody QCDTO qcDetails) {
        QC savedQC = qcService.saveQCDetails(qcDetails);
        return ResponseEntity.ok(savedQC);
    }

    @GetMapping("/getQCDetails/{policyId}")
    public ResponseEntity<List<QC>> getQCDetails(@PathVariable String policyId) {
        List<QC> qcDetails = qcService.fetchQCDetails(policyId);
        return ResponseEntity.ok(qcDetails);
    }

    @PostMapping("/updateRecords")
    public ResponseEntity<List<QC>> updateRecords() {
        List<QC> updatedRecords = qcService.iterateAndUpdateRecords();
        return ResponseEntity.ok(updatedRecords);
    }

    @PostMapping("/updateQCRecords")
    public ResponseEntity<Void> updateQCRecords() {
        qcService.updateRecords();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/iterateAndUpdateQCRecords")
    public void iterateAndUpdateQCRecords() {
        qcService.iterateAndUpdateQCRecords();
    }
}
